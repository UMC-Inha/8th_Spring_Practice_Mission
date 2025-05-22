package umc.study.service.UserService;

import jakarta.validation.Valid;
import umc.study.domain.User;
import umc.study.web.dto.UserRequestDto;

public interface UserCommandService {
    User joinUser(UserRequestDto.@Valid JoinDto request);
}