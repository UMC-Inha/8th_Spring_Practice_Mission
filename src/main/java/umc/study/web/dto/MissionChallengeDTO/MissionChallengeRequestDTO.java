package umc.study.web.dto.MissionChallengeDTO;

import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import umc.study.validation.annotation.NotAlreadyChallenged;

public class MissionChallengeRequestDTO {
    @Getter
    @NotAlreadyChallenged
    public static class MissionChallengeJoinDTO {
        @NotNull
        Long memberId;
        @NotNull
        Long missionId;
    }
}
