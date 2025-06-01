package umc.service.user;

import umc.domain.User;
import umc.web.dto.user.UserRequestDTO;

public interface UserCommandService {

    User joinUser(UserRequestDTO.JoinDto request);

    void challengeMission(Long missionId);
}
