package umc.study.service.user;

import umc.study.domain.user.User;
import umc.study.web.dto.request.UserRequestDto;

public interface UserCommandService {
    User joinUser (UserRequestDto.JoinDto request);
}
