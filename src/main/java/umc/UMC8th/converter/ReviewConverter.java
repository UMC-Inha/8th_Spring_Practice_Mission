package umc.UMC8th.converter;

import umc.UMC8th.domain.Member;
import umc.UMC8th.domain.Review;
import umc.UMC8th.domain.Store;
import umc.UMC8th.dto.CreateReviewRequest;
import umc.UMC8th.dto.CreateReviewResponse;

import java.time.LocalDateTime;

public class ReviewConverter {

    public static Review toReview(CreateReviewRequest request, Member member, Store store) {
        return Review.builder()
                .title(request.getTitle())
                .reviewText(request.getReviewText())
                .rating(request.getRating())
                .member(member)
                .store(store)
                .build();
    }

    public static CreateReviewResponse toReviewResponse(Review review) {
        return CreateReviewResponse.builder()
                .reviewId(review.getId())
                .title(review.getTitle())
                .reviewText(review.getReviewText())
                .rating(review.getRating())
                .createdAt(LocalDateTime.now())
                .build();
    }
}
