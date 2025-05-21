package umc.study.web.converter.review;

import umc.study.domain.review.Review;
import umc.study.web.controller.review.dto.ReviewRequestDTO;
import umc.study.web.controller.review.dto.ReviewResponseDTO;


public class ReviewConverter {

    public static ReviewResponseDTO.addResultDto toAddResultDTO(Review review) {
        return ReviewResponseDTO.addResultDto.builder()
                .comment(review.getBody())
                .reviewId(review.getId())
                .score(review.getScore())
                .imageList(review.getImageList())
                .build();
    }


    public static Review toReview(ReviewRequestDTO.AddDto request) {

        return Review.builder()
                .body(request.getComment())
                .imageList(request.getImageList())
                .score(request.getScore())
                .build();

    }
}
