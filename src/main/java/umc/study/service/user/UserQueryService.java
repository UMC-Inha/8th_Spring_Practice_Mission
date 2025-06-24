package umc.study.service.user;

import jakarta.servlet.http.HttpServletRequest;
import umc.study.web.dto.response.UserResponseDto;

public interface UserQueryService {
    UserResponseDto.UserInfoDTO getUserInfo(HttpServletRequest request);
}
