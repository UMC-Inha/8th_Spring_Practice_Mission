package umc.study.converter;

import umc.study.domain.enums.MissionStatus;
import umc.study.domain.mapping.UserMission;
import umc.study.domain.mission.Mission;
import umc.study.domain.user.User;
import umc.study.web.dto.response.UserMissionResponseDto;

import java.time.LocalDateTime;

public class UserMissionConverter {

    public static UserMission toUserMission(User user, Mission mission) {
        return UserMission.builder()
                .user(user)
                .mission(mission)
                .status(MissionStatus.IN_PROGRESS)
                .build();
    }

    public static UserMissionResponseDto.RegisterResultDto toUserMissionRegisterResultDto(UserMission userMission) {
        return UserMissionResponseDto.RegisterResultDto.builder()
                .userMissionId(userMission.getId())
                .userId(userMission.getUser().getId())
                .missionId(userMission.getMission().getMissionId())
                .status(userMission.getStatus())
                .createdAt(userMission.getCreatedAt())
                .build();
    }
}
