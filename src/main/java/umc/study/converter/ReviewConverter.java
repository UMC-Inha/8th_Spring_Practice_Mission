package umc.study.converter;

import org.springframework.data.domain.Page;
import umc.study.domain.Review;
import umc.study.domain.Store;
import umc.study.web.dto.ReviewDTO.ReviewRequestDTO;
import umc.study.web.dto.ReviewDTO.ReviewResponseDTO;
import java.util.ArrayList;

public class ReviewConverter {
    public static ReviewResponseDTO.ReviewJoinResultDTO toReviewJoinResultDTO(Review review) {
        return ReviewResponseDTO.ReviewJoinResultDTO.builder()
                .reviewId(review.getId())
                .storeId(review.getStore().getId())
                .createdAt(review.getCreatedAt())
                .build();
    }

    public static Review toReview(ReviewRequestDTO.ReviewJoinDTO request, Store store) {
        return Review.builder()
                .body(request.getBody())
                .score(request.getScore())
                .store(store)
                .reviewImageList(new ArrayList<>())
                .build();
    }
}
