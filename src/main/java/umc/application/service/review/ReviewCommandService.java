package umc.application.service.review;

import umc.infrastructure.persistence.entity.review.Review;
import umc.presentation.dto.review.ReviewRequestDto;
import umc.presentation.dto.review.ReviewResponseDto;

public interface ReviewCommandService {
    ReviewResponseDto.CreateReviewResponseDto createReview(ReviewRequestDto.CreateReviewRequestDto request);
}
