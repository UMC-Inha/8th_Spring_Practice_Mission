package umc.study.service.MissionService;

import umc.study.domain.Mission;
import umc.study.web.dto.request.MissionRequestDTO;

public interface MissionCommandService {
    public Mission createMission(Long storeId, MissionRequestDTO.createMissionDTO request);
}
