package umc.study.web.dto.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import umc.study.domain.enums.MissionStatus;

import java.time.LocalDateTime;
import java.util.List;

public class UserMissionResponseDto {


    @Builder
    @Getter
    @NoArgsConstructor
    @AllArgsConstructor
    public static class UserMissionListDto {
        private List<UserMissionDto> userMissions;
        private boolean hasNext;
    }

    @Builder
    @Getter
    @NoArgsConstructor
    @AllArgsConstructor
    public static class UserMissionDto {
        private Long missionId;
        private String storeName;
        private String title;
        private Integer rewardPoint;
        private String missionStatus;
        private LocalDateTime createdAt;
    }

    @Builder
    @Getter
    @NoArgsConstructor
    @AllArgsConstructor
    public static class CompletedResultDto {
        private Long userMissionId;
        private Long userId;
        private Long missionId;
        private MissionStatus status;
        private LocalDateTime updatedAt;
    }

    @Builder
    @Getter
    @NoArgsConstructor
    @AllArgsConstructor
    public static class RegisterResultDto {
        private Long userMissionId;
        private Long userId;
        private Long missionId;
        private MissionStatus status;
        private LocalDateTime createdAt;
    }
}