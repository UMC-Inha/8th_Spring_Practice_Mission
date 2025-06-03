package umc.study.converter;

import umc.study.domain.mission.Mission;
import umc.study.domain.store.Store;
import umc.study.web.dto.request.MissionRequestDto;
import umc.study.web.dto.response.MissionResponseDto;

import java.time.LocalDateTime;

public class MissionConverter {

    public static Mission toMission(MissionRequestDto.RegisterDto request, Store store) {
        return Mission.builder()
                .store(store)
                .title(request.getTitle())
                .missionContent(request.getMissionContent())
                .rewardPoint(request.getRewardPoint())
                .endDate(request.getEndDate())
                .build();
    }

    public static MissionResponseDto.RegisterResultDto toMissionRegisterResultDto(Mission mission) {
        return MissionResponseDto.RegisterResultDto.builder()
                .missionId(mission.getMissionId())
                .title(mission.getTitle())
                .rewardPoint(mission.getRewardPoint())
                .createdAt(mission.getCreatedAt())
                .build();
    }
}
