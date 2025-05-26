package umc.presentation.dto.user;

import lombok.Builder;

import java.time.LocalDateTime;

public class UserResponseDTO {

    @Builder
    public record JoinResultDto(Long id,
                                LocalDateTime createdAt){

    }
}
