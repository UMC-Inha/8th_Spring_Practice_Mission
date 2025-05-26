package umc.study.web.converter.review;

import jakarta.validation.constraints.NotBlank;
import org.springframework.data.domain.Page;
import umc.study.domain.review.Review;
import umc.study.web.controller.review.dto.ReviewRequestDTO;
import umc.study.web.controller.review.dto.ReviewResponseDTO;
import umc.study.web.controller.review.dto.ReviewResponseDTO.getReviewListResultDto;

import java.util.List;


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

    public static Page<getReviewListResultDto> toGetReviewResultDTO(Page<Review> reviewList) {
        return reviewList.map(review -> getReviewListResultDto.builder()
                .reviewId(review.getId())
                .comment(review.getBody())
                .score(review.getScore())
                .build()
        );
    }



}
