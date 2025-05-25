package umc.UMC8th.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class MemberResponseDTO {

    @Getter
    @Builder
    @NoArgsConstructor
    @AllArgsConstructor
    public static class JoinResultDto {
        private Long userId;
        private String email;
        private String nickname;
        private LocalDate userBirth;
        private String userAddress;
        private String foodCategories;
        private LocalDateTime createdAt;
    }
}
