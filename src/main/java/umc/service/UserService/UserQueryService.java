package umc.service.UserService;

import org.springframework.security.core.Authentication;

import jakarta.servlet.http.HttpServletRequest;
import umc.dto.UserResponseDto;

public interface UserQueryService {
	UserResponseDto.UserInfoDTO getUserInfo(Authentication authentication);
}
