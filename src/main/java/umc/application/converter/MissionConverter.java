package umc.application.converter;

import umc.infrastructure.persistence.entity.mission.Mission;
import umc.presentation.dto.mission.MissionRequestDto;
import umc.presentation.dto.mission.MissionResponseDto;

public class MissionConverter {
    public static Mission toMission(MissionRequestDto.MissionCreateDto request) {
        return Mission.builder()
                .content(request.content())
                .dueDate(request.dueDate())
                .point(request.point())
                .build();
    }

    public static  MissionResponseDto.MissionCreateResponseDto toResponse (Mission mission){
        return MissionResponseDto.MissionCreateResponseDto.builder()
                .missionId(mission.getId())
                .content(mission.getContent())
                .dueDate(mission.getDueDate())
                .createdAt(mission.getCreatedAt())
                .build();
    }

}
