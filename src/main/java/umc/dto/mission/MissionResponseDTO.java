package umc.dto.mission;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import umc.domain.enums.MissionStatus;

import java.time.LocalDateTime;

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
    public static class ChallengeMissionResultDto {
        Long memberMissionId;
        Long missionId;
        Long memberId;
        MissionStatus missionStatus;
        LocalDateTime startAt;
        LocalDateTime doneAt;
    }
}
