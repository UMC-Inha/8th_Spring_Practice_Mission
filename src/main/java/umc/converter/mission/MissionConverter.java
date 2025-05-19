package umc.converter.mission;

import umc.domain.Mission;
import umc.domain.Restaurant;
import umc.dto.mission.MissionRequestDTO;
import umc.dto.mission.MissionResponseDTO;

import java.time.LocalDateTime;

public class MissionConverter {

    public static MissionResponseDTO.CreateMissionResultDto toCreateMissionResultDto (Mission mission) {
        return MissionResponseDTO.CreateMissionResultDto.builder()
                .missionId(mission.getId())
                .createdAt(LocalDateTime.now())
                .build();
    }

    public static Mission toMission (MissionRequestDTO.CreateMissionDto request, Restaurant restaurant) {
        return Mission.builder()
                .missionPrice(request.getMissionPrice())
                .doneAt(request.getDoneAt())
                .content(request.getContent())
                .reward(request.getReward())
                .restaurant(restaurant)
                .build();
    }
}
