package umc.study.converter;

import umc.study.domain.Mission;
import umc.study.domain.Store;
import umc.study.web.dto.MissionDTO.MissionRequestDTO;
import umc.study.web.dto.MissionDTO.MissionResponseDTO;

import java.time.LocalDateTime;

public class MissionConverter {
    public static MissionResponseDTO.MissionJoinResultDTO toMissionJoinResultDTO(Mission mission) {
        return MissionResponseDTO.MissionJoinResultDTO.builder()
                .missionId(mission.getId())
                .createdAt(mission.getCreatedAt())
                .build();
    }

    public static Mission toMission(MissionRequestDTO.MissionJoinDTO request, Store store) {
        return Mission.builder()
                .body(request.getBody())
                .reward(request.getReward())
                .deadline(request.getDeadLine())
                .store(store)
                .build();
    }
}
