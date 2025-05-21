package umc.service.mission;

import jakarta.validation.Valid;
import umc.web.dto.mission.MissionRequestDTO;

public interface MissionCommandService {
    void createMission(MissionRequestDTO.createMissionDTO request, Long restaurantId);
}
