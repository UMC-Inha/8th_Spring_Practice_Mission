package umc.study.web.dto.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import umc.study.domain.user.User;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

public class ReviewResponseDto {

    @Getter
    @Builder
    @AllArgsConstructor
    @NoArgsConstructor
    public static class UserReviewListResult {
        private List<UserReviewDto> reviews;
        private boolean hasNext;
    }

    @Getter
    @Builder
    @AllArgsConstructor
    @NoArgsConstructor
    public static class UserReviewDto {
        private Long reviewId;
        private String storeName;
        private String content;
        private BigDecimal score;
        private LocalDateTime createdAt;
    }

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
