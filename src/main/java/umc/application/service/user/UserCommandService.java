package umc.application.service.user;

import umc.infrastructure.persistence.entity.user.User;
import umc.presentation.dto.user.UserRequestDTO;

public interface UserCommandService {
    User joinUser(UserRequestDTO.JoinDto request);
}
