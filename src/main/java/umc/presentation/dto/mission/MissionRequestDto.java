package umc.presentation.dto.mission;

import umc.common.validation.annotation.ExistStore;

import java.time.LocalDateTime;

public class MissionRequestDto {
    public record MissionCreateDto(@ExistStore Long storeId,
                                   String content,
                                   Integer point,
                                   LocalDateTime dueDate) {

    }
}
