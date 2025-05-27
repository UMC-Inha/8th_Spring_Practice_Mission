package umc.study.service.UserMissionService;

import umc.study.domain.mapping.UserMission;
import umc.study.web.dto.MissionRequestDto;
import umc.study.web.dto.ReviewRequestDto;

public interface UserMissionCommandService {
    UserMission createUserMission(MissionRequestDto requestDto);
}
