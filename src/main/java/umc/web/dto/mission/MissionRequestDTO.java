package umc.web.dto.mission;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

public class MissionRequestDTO {

    @Getter
    public static class createMissionDTO{
        @NotBlank
        String name;
        @NotBlank
        String contents;
        @NotNull
        Integer points;
    }

}
