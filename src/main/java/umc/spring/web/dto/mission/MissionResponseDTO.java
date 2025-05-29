package umc.spring.web.dto.mission;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import umc.spring.domain.Mission;
import umc.spring.domain.enums.MissionStatus;
import umc.spring.web.dto.review.ReviewResponseDTO;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

public class MissionResponseDTO {

    @Builder
    @Getter
    @NoArgsConstructor
    @AllArgsConstructor
    public static class CreateMissionResultDto {
        Long missionId;
        LocalDateTime createdAt;
    }

    @Builder
    @Getter
    @NoArgsConstructor
    @AllArgsConstructor
    public static class ChallengeMissionResultDto{
        Long memberMissionId;
        Long missionId;
        Long memberId;
        MissionStatus status;
        LocalDateTime dueDate;
    }

    @Builder
    @Getter
    @NoArgsConstructor
    @AllArgsConstructor
    public static class MissionPreviewListResultDto {
        List<MissionResponseDTO.MissionPreviewDto> missionList;
        Integer listSize;
        Integer totalPage;
        Long totalElements;
        Boolean isFirst;
        Boolean isLast;
    }

    @Builder
    @Getter
    @NoArgsConstructor
    @AllArgsConstructor
    public static class MissionPreviewDto {
        Long missionId;
        String title;
        String content;
        int reward;
        LocalDate dueDate;
        LocalDate createdAt;
    }
}
