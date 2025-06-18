package umc.service.UserService;

import java.util.Collections;
import java.util.List;

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import lombok.RequiredArgsConstructor;
import umc.apiPayload.code.status.ErrorStatus;
import umc.apiPayload.exception.GeneralException;
import umc.config.jwt.JwtTokenProvider;
import umc.converter.PreferredCategoryConverter;
import umc.converter.UserConverter;
import umc.domain.Category;
import umc.domain.Region;
import umc.domain.User;
import umc.domain.mapping.PreferredCategory;
import umc.domain.security.RefreshToken;
import umc.dto.UserRequestDto;
import umc.dto.UserResponseDto;
import umc.dto.WithdrawUserDto;
import umc.repository.AlarmRepository.AlarmRepository;
import umc.repository.CategoryRepository.CategoryRepository;
import umc.repository.PreferredCategoryRepository.PreferredCategoryRepository;
import umc.repository.RefreshTokenRepository.RefreshTokenRepository;
import umc.repository.RegionRepository.RegionRepository;
import umc.repository.ReviewRepository.ReviewRepository;
import umc.repository.UserRepository.UserRepository;
import umc.repository.UserTermRepository.UserTermRepository;

@Service
@RequiredArgsConstructor
public class UserCommandServiceImpl implements UserCommandService{

	private final UserRepository userRepository;
	private final ReviewRepository reviewRepository;
	private final AlarmRepository alarmRepository;
	private final PreferredCategoryRepository preferredCategoryRepository;
	private final UserTermRepository userTermRepository;
	private final CategoryRepository categoryRepository;
	private final RegionRepository regionRepository;
	private final PasswordEncoder passwordEncoder;
	private final JwtTokenProvider jwtTokenProvider;
	private final RefreshTokenRepository refreshTokenRepository;

	@Override
	@Transactional
	public WithdrawUserDto withdrawUser(Long userId) {
		User user = userRepository.findById(userId).orElseThrow(() -> new RuntimeException("존재하지 않는 유저입니다."));

		reviewRepository.deleteAllByUserId(userId);
		alarmRepository.deleteAllByUserId(userId);
		preferredCategoryRepository.deleteAllByUserId(userId);
		userTermRepository.deleteAllByUserId(userId);

		userRepository.delete(user);

		return new WithdrawUserDto(true, userId);
	}

	@Override
	@Transactional
	public UserResponseDto.JoinResultDTO joinUser(UserRequestDto.JoinDto request) {

		// 지역 검색
		Region region = regionRepository.findByName(request.getAddress())
			.orElseThrow(() -> new GeneralException(ErrorStatus.REGION_NOT_FOUND));

		// 유저 생성
		User newUser = UserConverter.toUser(request, region);
		newUser.encodePassword(passwordEncoder.encode(request.getPassword()));
		
		// 해당되는 카테고리 추출
		List<Category> categoryList = request.getPreferCategory().stream()
			.map(category -> {
				return categoryRepository.findById(category).orElseThrow(() -> new GeneralException(ErrorStatus.FOOD_CATEGORY_NOT_FOUND));
			}).toList();

		// 선호 카테고리 목록으로 변환
		List<PreferredCategory> preferredCategoryList = PreferredCategoryConverter.toPreferredCategoryList(
			categoryList);

		// 연관 관계 설정
		preferredCategoryList.forEach(userPrefer -> {userPrefer.changeUser(newUser);});

		return UserConverter.toJoinResultDto(userRepository.save(newUser));
	}

	@Override
	@Transactional
	public UserResponseDto.LoginResultDTO loginUser(UserRequestDto.LoginRequestDto request) {
		User user = userRepository.findByEmail(request.getEmail())
			.orElseThrow(()-> new GeneralException(ErrorStatus.USER_NOT_FOUND));

		if(!passwordEncoder.matches(request.getPassword(), user.getPassword())) {
			throw new GeneralException(ErrorStatus.INVALID_PASSWORD);
		}

		Authentication authentication = new UsernamePasswordAuthenticationToken(
			user.getEmail(), null,
			Collections.singleton(() -> user.getRole().name())
		);

		String accessToken = jwtTokenProvider.generateToken(authentication);
		String refreshToken = jwtTokenProvider.generateRefreshToken();

		refreshTokenRepository.save(UserConverter.toRefreshToken(user.getEmail(), refreshToken));

		return UserConverter.toLoginResultDto(
			user.getId(),
			accessToken,
			refreshToken
		);
	}

	@Override
	@Transactional
	public UserResponseDto.ReissueDto reissue(UserRequestDto.ReissueDto request) {

		// 1. refreshToken 검증
		if (!jwtTokenProvider.validateToken(request.getRefreshToken())) {
			throw new GeneralException(ErrorStatus.INVALID_TOKEN);
		}

		// 2. accessToken 에서 Authentication 추출
		Authentication authentication = jwtTokenProvider.getAuthentication(request.getAccessToken());

		// 3. Authentication에서 사용자의 email로 refreshToken 가져오기
		RefreshToken refreshToken = refreshTokenRepository.findByEmail(authentication.getName())
			.orElseThrow(() -> new GeneralException(ErrorStatus.INVALID_TOKEN));

		// 4. 입력 refreshToken, 찾은 refreshToken 일치성 검사
		if (!refreshToken.getValue().equals(request.getRefreshToken())) {
			throw new GeneralException(ErrorStatus.INVALID_TOKEN);
		}

		// 5. 새로운 토큰 생성
		String newAccessToken = jwtTokenProvider.generateToken(authentication);
		String newRefreshToken = !jwtTokenProvider.validateToken(refreshToken.getValue()) ?
			jwtTokenProvider.generateRefreshToken() : request.getRefreshToken();

		return UserConverter.toReissueDto(newAccessToken, newRefreshToken);
	}
}
