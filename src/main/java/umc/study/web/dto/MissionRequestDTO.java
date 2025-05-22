package umc.study.web.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Past;
import jakarta.validation.constraints.Positive;
import lombok.Getter;

import java.time.LocalDateTime;

public class MissionRequestDTO {
    @Getter
    public static class createMissionDTO {
        @NotBlank
        String missionSpec;
        @NotNull
        @Positive
        Integer reward;
        @Past
        LocalDateTime deadline;
    }
}
