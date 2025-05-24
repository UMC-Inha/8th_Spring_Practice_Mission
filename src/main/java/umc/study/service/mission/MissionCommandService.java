package umc.study.service.mission;

import umc.study.domain.mission.Mission;
import umc.study.web.dto.request.MissionRequestDto;

public interface MissionCommandService {
    Mission registerMission(MissionRequestDto.RegisterDto request);
}
