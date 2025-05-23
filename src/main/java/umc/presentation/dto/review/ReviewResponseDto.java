package umc.presentation.dto.review;

import lombok.Builder;

public class ReviewResponseDto {
    @Builder
    public record CreateReviewResponseDto(Long reviewId){ }
}
