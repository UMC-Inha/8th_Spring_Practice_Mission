package umc.service.UserService;

import java.util.List;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import lombok.RequiredArgsConstructor;
import umc.apiPayload.code.status.ErrorStatus;
import umc.apiPayload.exception.GeneralException;
import umc.converter.PreferredCategoryConverter;
import umc.converter.UserConverter;
import umc.domain.Category;
import umc.domain.Region;
import umc.domain.User;
import umc.domain.mapping.PreferredCategory;
import umc.dto.UserRequestDto;
import umc.dto.UserResponseDto;
import umc.dto.WithdrawUserDto;
import umc.repository.AlarmRepository.AlarmRepository;
import umc.repository.CategoryRepository.CategoryRepository;
import umc.repository.PreferredCategoryRepository.PreferredCategoryRepository;
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

}
