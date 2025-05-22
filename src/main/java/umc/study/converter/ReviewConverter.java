package umc.study.converter;

import umc.study.domain.Review;
import umc.study.domain.ReviewPicture;
import umc.study.domain.Store;
import umc.study.web.dto.ReviewRequestDTO;
import umc.study.web.dto.ReviewResponseDTO;

import java.util.List;
import java.util.stream.Collectors;

public class ReviewConverter {
    public static Review toReview(Store store, ReviewRequestDTO.createReviewDto dto) {
        return Review.builder()
                .score(dto.getScore())
                .body(dto.getBody())
                .store(store)
                .build();
    }

    public static List<ReviewPicture> toReviewPictures(List<String> urls, Review review) {
        return urls.stream()
                .map(url -> ReviewPicture.builder()
                        .review(review)
                        .url(url)
                        .build())
                .collect(Collectors.toList());
    }

    public static ReviewResponseDTO.createResultDTO toReviewResponseDto(Review review) {
        return ReviewResponseDTO.createResultDTO.builder()
                .reviewId(review.getId())
                .createdAt(review.getCreatedAt())
                .build();
    }
}
