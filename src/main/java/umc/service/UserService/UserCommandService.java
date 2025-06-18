package umc.service.UserService;

import umc.dto.UserRequestDto;
import umc.dto.UserResponseDto;
import umc.dto.WithdrawUserDto;

public interface UserCommandService {
	WithdrawUserDto withdrawUser(Long userId);
	UserResponseDto.JoinResultDTO joinUser(UserRequestDto.JoinDto request);
	UserResponseDto.LoginResultDTO loginUser(UserRequestDto.LoginRequestDto request);
	UserResponseDto.ReissueDto reissue(UserRequestDto.ReissueDto request);
}
