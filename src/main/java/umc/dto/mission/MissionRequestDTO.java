package umc.dto.mission;

import jakarta.validation.constraints.NotNull;
import lombok.Getter;

import java.time.LocalDateTime;

public class MissionRequestDTO {

    @Getter
    public static class CreateMissionDto {
        @NotNull
        Integer missionPrice;
        @NotNull
        String content;
        @NotNull
        Integer reward;
        @NotNull
        LocalDateTime doneAt;
    }

    @Getter
    public static class ChallengeMissionDto {
        @NotNull
        Long memberId;
    }
}
