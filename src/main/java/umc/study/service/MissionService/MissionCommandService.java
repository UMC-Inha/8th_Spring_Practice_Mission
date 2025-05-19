package umc.study.service.MissionService;

import umc.study.domain.Mission;
import umc.study.web.dto.Mission.MissionRequestDto;

public interface MissionCommandService {

    Mission registerMission(MissionRequestDto.JoinDto request);
}
