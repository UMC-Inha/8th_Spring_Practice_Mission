package umc.study.web.dto.Mission;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;

import java.time.LocalDate;

public class MissionRequestDto {
    @Getter
    public static class JoinDto{
        @NotBlank
        String name;

        @NotBlank @Min(0)
        Integer reward;

        @NotBlank
        LocalDate deadline;

        @NotBlank
        String missionSpec;

        @NotBlank
        Long storeId;
    }
}
