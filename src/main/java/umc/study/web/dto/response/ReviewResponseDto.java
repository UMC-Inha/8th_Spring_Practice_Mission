package umc.study.web.dto.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

public class ReviewResponseDto {

    @Builder
    @Getter
    @NoArgsConstructor
    @AllArgsConstructor
    public static class RegisterResultDto{
        private Long id;
        private Long userId;
        private String storeName;
        private String reviewContent;
        private LocalDate createdAt;
    }
}
