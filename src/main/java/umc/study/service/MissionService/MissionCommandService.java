package umc.study.service.MissionService;

import umc.study.domain.Mission;
import umc.study.web.dto.MissionDTO.MissionRequestDTO;

public interface MissionCommandService {
    Mission joinMission(MissionRequestDTO.MissionJoinDTO request);
}
