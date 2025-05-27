package umc.study.converter;

import umc.study.domain.Mission;
import umc.study.domain.enums.MissionStatus;
import umc.study.domain.mapping.UserMission;
import umc.study.web.dto.MissionRequestDto;
import umc.study.web.dto.MissionResponseDto;

public class MissionConverter {
    public static MissionResponseDto.toResultDto toMissionResponseDto(Mission mission) {
        return MissionResponseDto.toResultDto.builder()
                .missionId(mission.getId())
                .point(mission.getPoint())
                .deadline(mission.getDeadline())
                .storeName(mission.getStore().getName())
                .build();
    }

    public static UserMission toUserMission(MissionRequestDto requestDto) {
        return UserMission.builder()
                .status(MissionStatus.CHALLENGING)
                .build();
    }
}
