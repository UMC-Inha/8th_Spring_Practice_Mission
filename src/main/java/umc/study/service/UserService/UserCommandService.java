package umc.study.service.UserService;

import jakarta.validation.Valid;
import umc.study.domain.User;
import umc.study.web.dto.UserRequestDto;
import umc.study.web.dto.UserResponseDto;

public interface UserCommandService {
    User joinUser(UserRequestDto.@Valid JoinDto request);
    UserResponseDto.LoginResultDTO loginUser(UserRequestDto.LoginRequestDTO request);

}