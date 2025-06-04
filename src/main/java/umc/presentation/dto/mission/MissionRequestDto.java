package umc.presentation.dto.mission;

import umc.common.validation.annotation.ExistStore;
import umc.common.validation.annotation.ExistUser;

import java.time.LocalDateTime;

public class MissionRequestDto {
    public record MissionCreateDto(@ExistStore Long storeId,
                                   String content,
                                   Integer point,
                                   LocalDateTime dueDate) { }

    public record AddMissionToUserDto(@ExistUser Long userId, Long missionId) { }

    public record MissionStateChangeDto(Long missionId, Long userId) {}

}
