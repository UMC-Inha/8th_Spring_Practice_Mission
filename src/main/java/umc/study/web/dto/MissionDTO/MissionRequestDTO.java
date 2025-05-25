package umc.study.web.dto.MissionDTO;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;

import java.time.LocalDate;

public class MissionRequestDTO {

    @Getter
    public static class MissionJoinDTO {
        @NotBlank
        String body;
        @NotNull
        Integer reward;
        @NotNull
        LocalDate deadLine;
        @NotNull
        Long storeId;
    }
}
