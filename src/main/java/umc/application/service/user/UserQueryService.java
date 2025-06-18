package umc.application.service.user;

import jakarta.servlet.http.HttpServletRequest;
import umc.presentation.dto.user.UserResponseDTO;

public interface UserQueryService {
    UserResponseDTO.UserInfoDto getUserInfo(HttpServletRequest request);
}
