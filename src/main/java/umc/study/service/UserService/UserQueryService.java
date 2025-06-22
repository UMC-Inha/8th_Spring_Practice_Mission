package umc.study.service.UserService;

import jakarta.servlet.http.HttpServletRequest;
import umc.study.web.dto.UserResponseDto;

public interface UserQueryService {
    UserResponseDto.UserInfoDTO getUserInfo(HttpServletRequest request);
}
