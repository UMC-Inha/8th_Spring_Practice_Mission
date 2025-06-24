package umc.study.service.user;

import umc.study.domain.user.User;
import umc.study.web.dto.request.UserRequestDto;
import umc.study.web.dto.response.UserResponseDto;

public interface UserCommandService {
    User joinUser (UserRequestDto.JoinDto request);
    UserResponseDto.LoginResultDTO loginUser(UserRequestDto.LoginRequestDTO request);
}
