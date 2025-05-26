package umc.study.web.controller.mission.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import umc.study.domain.enums.MissionStatus;

import java.time.LocalDateTime;

public class MemberMissionResponseDTO {

    @Getter
    @AllArgsConstructor
    @NoArgsConstructor
    @Builder
    public static class MissionInProgressDTO {
        private Long memberMissionId;
        private Long missionId;
        private String missionSpec;
        private String storeName;
        private Integer point;
        private String local;
        private LocalDateTime deadline;
        private MissionStatus status;
        private LocalDateTime createdAt;
    }
}