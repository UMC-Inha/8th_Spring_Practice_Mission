package umc.spring.web.dto.mission;

import jakarta.validation.constraints.NotNull;
import lombok.Getter;

import java.time.LocalDateTime;

public class MissionRequestDTO {

    @Getter
    public static class CreateMissionDTO{
        @NotNull
        String title;
        @NotNull
        String content;
        @NotNull
        Integer reward;
        @NotNull
        LocalDateTime dueDate;
    }

    @Getter
    public static class ChallengeMissionDto{
        @NotNull
        Long memberId;
    }
}
