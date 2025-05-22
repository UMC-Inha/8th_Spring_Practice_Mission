package umc.study.converter;

import umc.study.domain.Mission;
import umc.study.domain.Store;
import umc.study.web.dto.MissionRequestDTO;
import umc.study.web.dto.MissionResponseDTO;

public class MissionConverter {
    public static MissionResponseDTO.createResultDTO toCreateResultDTO(Mission mission) {
        return MissionResponseDTO.createResultDTO.builder()
                .missionId(mission.getId())
                .storeId(mission.getStore().getId())
                .createdAt(mission.getCreatedAt())
                .build();
    }

    public static Mission toMission(Store store, MissionRequestDTO.createMissionDTO request) {
        return Mission.builder()
                .store(store)
                .missionSpec(request.getMissionSpec())
                .reward(request.getReward())
                .deadline(request.getDeadline())
                .build();
    }
}
