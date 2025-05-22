package umc.application.service.mission;

import org.springframework.stereotype.Service;
import umc.presentation.dto.mission.MissionRequestDto;
import umc.presentation.dto.mission.MissionResponseDto;

public interface MissionCommandService {
    MissionResponseDto.MissionCreateResponseDto createMission(MissionRequestDto.MissionCreateDto request);
}
