package umc.study.web.dto.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import umc.study.domain.enums.MissionStatus;

import java.time.LocalDateTime;

public class UserMissionResponseDto {

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