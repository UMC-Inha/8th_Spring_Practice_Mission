package umc.service.user;

import umc.domain.User;
import umc.web.dto.user.UserRequestDTO;
import umc.web.dto.user.UserResponseDTO;

public interface UserCommandService {

    User joinUser(UserRequestDTO.JoinDto request);

    void challengeMission(Long missionId);

    UserResponseDTO.LoginResultDTO loginUser(UserRequestDTO.LoginRequestDTO request);
}
