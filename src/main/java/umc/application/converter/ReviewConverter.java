package umc.application.converter;

import umc.infrastructure.persistence.entity.review.Review;
import umc.presentation.dto.review.ReviewRequestDto;
import umc.presentation.dto.review.ReviewResponseDto;

public class ReviewConverter {
    public static Review toReview(ReviewRequestDto.CreateReviewRequestDto requestDto) {
        return Review.builder()
                .content(requestDto.content())
                .score(requestDto.score())
                .build();
    }

    public static ReviewResponseDto.CreateReviewResponseDto toCreateReviewResponseDto(Review review) {
        return ReviewResponseDto.CreateReviewResponseDto.builder()
                .reviewId(review.getId())
                .build();
    }
}
