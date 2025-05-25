package umc.study.web.dto.MissionChallengeDTO;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

public class MissionChallengeResponseDTO {

    @Getter
    @Builder
    @NoArgsConstructor
    @AllArgsConstructor
    public static class MissionChallengeJoinResultDTO {
        Long memberMissionId;
        LocalDateTime createdAt;
    }
}
