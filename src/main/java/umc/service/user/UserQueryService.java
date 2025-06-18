package umc.service.user;

import jakarta.servlet.http.HttpServletRequest;
import umc.web.dto.user.UserResponseDTO;

public interface UserQueryService {

    UserResponseDTO.UserInfoDTO getUserInfo(HttpServletRequest request);
}
