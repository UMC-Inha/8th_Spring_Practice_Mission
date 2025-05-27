package umc.study.web.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

public class MissionResponseDto {
    @Builder
    @Getter
    @NoArgsConstructor
    @AllArgsConstructor
    public static class toResultDto {
        private Long missionId;
        private String missionName;
        private Integer point;
        private LocalDate deadline;
        private String storeName;
    }
}