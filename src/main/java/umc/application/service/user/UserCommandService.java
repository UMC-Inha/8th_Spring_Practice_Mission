package umc.application.service.user;

import umc.infrastructure.persistence.entity.user.User;
import umc.presentation.dto.user.UserRequestDTO;
import umc.presentation.dto.user.UserResponseDTO;

public interface UserCommandService {
    UserResponseDTO.JoinResultDto joinUser(UserRequestDTO.JoinDto request);
}
