package umc.service.UserService;

import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import umc.apiPayload.code.status.ErrorStatus;
import umc.apiPayload.exception.GeneralException;
import umc.config.jwt.JwtTokenProvider;
import umc.converter.UserConverter;
import umc.domain.User;
import umc.dto.UserResponseDto;
import umc.repository.UserRepository.UserRepository;

@Service
@RequiredArgsConstructor
public class UserQueryServiceImpl implements UserQueryService {

	private final UserRepository userRepository;

	@Override
	public UserResponseDto.UserInfoDTO getUserInfo(Authentication authentication) {

		String email = authentication.getName();

		User user = userRepository.findByEmail(email)
			.orElseThrow(()-> new GeneralException(ErrorStatus.USER_NOT_FOUND));

		return UserConverter.toUserInfoDTO(user);
	}
}
