package umc.converter.review;

import umc.domain.Member;
import umc.domain.Restaurant;
import umc.domain.Review;
import umc.dto.review.ReviewRequestDTO;
import umc.dto.review.ReviewResponseDTO;

import java.time.LocalDateTime;

public class ReviewConverter {

    public static ReviewResponseDTO.WriteReviewResultDto toWriteReviewResultDto (Review review) {
        return ReviewResponseDTO.WriteReviewResultDto.builder()
                .reviewId(review.getId())
                .createdAt(LocalDateTime.now())
                .build();
    }

    public static Review toReview(ReviewRequestDTO.WriteReviewDto request, Restaurant restaurant, Member member) {
        return Review.builder()
                .content(request.getContent())
                .score(request.getScore())
                .member(member)
                .restaurant(restaurant)
                .build();
    }
}
