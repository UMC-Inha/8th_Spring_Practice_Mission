package umc.study.web.dto.Mission;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class MissionResponseDto {
    @Builder
    @Getter
    @NoArgsConstructor
    @AllArgsConstructor
    public static class JoinResultDTO{
        Long missionId;
        Integer reward;
        LocalDate deadline;
        String missionSpec;
        Long storeId;
        String storeName;
        LocalDateTime createdAt;
    }
}
