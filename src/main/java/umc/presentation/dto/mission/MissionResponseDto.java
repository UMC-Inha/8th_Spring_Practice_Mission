package umc.presentation.dto.mission;

import lombok.Builder;

import java.time.LocalDateTime;

public class MissionResponseDto {
    @Builder
    public record MissionCreateResponseDto(Long missionId,
                                           String content,
                                           LocalDateTime dueDate,
                                           LocalDateTime createdAt) { }

    @Builder
    public record AddMissionToUserResponseDto(Long userId, Long missionId) { }

}
