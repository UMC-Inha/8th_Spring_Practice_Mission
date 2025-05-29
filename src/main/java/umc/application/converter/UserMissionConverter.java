package umc.application.converter;

import umc.infrastructure.persistence.entity.mission.Mission;
import umc.infrastructure.persistence.entity.mission.UserMission;
import umc.infrastructure.persistence.entity.mission.UserMissionPK;
import umc.infrastructure.persistence.entity.user.User;
import umc.presentation.dto.mission.MissionResponseDto;

public class UserMissionConverter {
    public static UserMission toUserMission(UserMissionPK pk, User user, Mission mission) {
        UserMission userMission = UserMission.builder().id(pk).build();
        userMission.changeUser(user);
        userMission.changeMission(mission);
        return userMission;
    }

    public static MissionResponseDto.AddMissionToUserResponseDto toResponse(UserMission userMission) {
        return MissionResponseDto.AddMissionToUserResponseDto.builder()
                .userId(userMission.getUser().getId())
                .missionId(userMission.getMission().getId())
                .build();
    }

    public static UserMissionPK toUserMissionPK(User user, Mission mission) {
        return UserMissionPK.builder()
                .userId(user.getId())
                .missionId(mission.getId())
                .build();
    }

    public static MissionResponseDto.MissionStateChangeResponseDto toMissionStateChangeResponseDto(UserMission userMission) {
        return MissionResponseDto.MissionStateChangeResponseDto.builder()
                .missionId(userMission.getId().getMissionId())
                .missionState(userMission.getState())
                .build();
    }
}
