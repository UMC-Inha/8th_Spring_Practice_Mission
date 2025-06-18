package umc.service;

import java.util.Collections;

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import lombok.RequiredArgsConstructor;
import umc.config.jwt.JwtTokenProvider;
import umc.service.KakaoClient.KakaoClient;
import umc.converter.UserConverter;
import umc.domain.User;
import umc.dto.KakaoDto;
import umc.dto.UserResponseDto;
import umc.repository.RefreshTokenRepository.RefreshTokenRepository;
import umc.repository.UserRepository.UserRepository;

@Service
@RequiredArgsConstructor
public class AuthService {

	private final KakaoClient kakaoClient;
	private final UserRepository userRepository;
	private final JwtTokenProvider jwtTokenProvider;
	private final RefreshTokenRepository refreshTokenRepository;

	@Transactional
	public UserResponseDto.LoginResultDTO oAuthLogin(String accessCode) {

		KakaoDto.OAuthToken oAuthToken = kakaoClient.requestToken(accessCode);
		KakaoDto.KakaoProfile kakaoProfile = kakaoClient.requestProfile(oAuthToken);

		String email = kakaoProfile.getKakao_account().getEmail();

		// 아래 코드 개선 방안
		// 1. 최초 회원가입은 임시토큰 발행해줘서 나머지 정보 입력 유도
		// 2. 기존 회원은 access + refresh 그대로 발행
		/*
		if(newUser(email)) {
			임시 token 생성;
			return;
		} else {
			accessToken, refreshToken 생성 및 저장;
			return;
		}
		 */
		User user = userRepository.findByEmail(email)
			.orElseGet(() -> createNewUser(kakaoProfile));

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

	private User createNewUser(KakaoDto.KakaoProfile kakaoProfile) {
		User newUser = UserConverter.toKakaoUser(
			kakaoProfile.getKakao_account().getEmail(),
			kakaoProfile.getKakao_account().getProfile().getNickname()
		);
		return userRepository.save(newUser);
	}
}