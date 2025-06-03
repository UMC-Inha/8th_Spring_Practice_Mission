package umc.study.converter;

import org.springframework.data.domain.Slice;
import umc.study.domain.enums.MissionStatus;
import umc.study.domain.mapping.UserMission;
import umc.study.domain.mission.Mission;
import umc.study.domain.user.User;
import umc.study.web.dto.response.UserMissionResponseDto;
import java.util.List;
import java.util.stream.Collectors;

public class UserMissionConverter {

    public static UserMission toUserMission(User user, Mission mission) {
        return UserMission.builder()
                .user(user)
                .mission(mission)
                .status(MissionStatus.IN_PROGRESS)
                .build();
    }

    public static UserMissionResponseDto.CompletedResultDto toUserMissionCompletedResultDto(UserMission userMission) {
        return UserMissionResponseDto.CompletedResultDto.builder()
                .userMissionId(userMission.getId())
                .userId(userMission.getUser().getId())
                .missionId(userMission.getMission().getMissionId())
                .status(userMission.getStatus())
                .updatedAt(userMission.getUpdatedAt())
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

    public static UserMissionResponseDto.UserMissionListDto toUserMissionListDto(Slice<UserMission> userMissionSlice) {
        List<UserMissionResponseDto.UserMissionDto> missionDtoList = userMissionSlice.getContent().stream()
                .map(UserMissionConverter::toUserMissionDto)
                .collect(Collectors.toList());

        return UserMissionResponseDto.UserMissionListDto.builder()
                .userMissions(missionDtoList)
                .hasNext(userMissionSlice.hasNext())
                .build();
    }

    private static UserMissionResponseDto.UserMissionDto toUserMissionDto(UserMission userMission) {
        return UserMissionResponseDto.UserMissionDto.builder()
                .missionId(userMission.getMission().getMissionId())
                .storeName(userMission.getMission().getStore().getStoreName())
                .title(userMission.getMission().getTitle())
                .rewardPoint(userMission.getMission().getRewardPoint())
                .missionStatus(userMission.getStatus().name())
                .createdAt(userMission.getCreatedAt())
                .build();
    }
}
