package umc.application.converter;

import org.springframework.data.domain.Page;
import umc.infrastructure.persistence.entity.review.Review;
import umc.presentation.dto.review.ReviewRequestDto;
import umc.presentation.dto.review.ReviewResponseDto;

import java.util.List;
import java.util.stream.Collectors;

public class ReviewConverter {
    public static Review toReview(ReviewRequestDto.CreateReviewRequestDto requestDto) {
        return Review.builder()
                .content(requestDto.content())
                .score(requestDto.score())
                .title(requestDto.title())
                .build();
    }

    public static ReviewResponseDto.CreateReviewResponseDto toCreateReviewResponseDto(Review review) {
        return ReviewResponseDto.CreateReviewResponseDto.builder()
                .reviewId(review.getId())
                .build();
    }

    public static ReviewResponseDto.ReviewPreviewDto toReviewPreviewDto(Review review) {
        return ReviewResponseDto.ReviewPreviewDto.builder()
                .ownerNickname(review.getUser().getName())
                .score(review.getScore())
                .createdAt(review.getCreatedAt())
                .body(review.getContent())
                .build();
    }

    public static ReviewResponseDto.ReviewPreviewListDto toReviewPreviewListDto(Page<Review> reviewList){
        List<ReviewResponseDto.ReviewPreviewDto> reviewPreViewDTOList = reviewList.stream()
                .map(ReviewConverter::toReviewPreviewDto).toList();
        return ReviewResponseDto.ReviewPreviewListDto.builder()
                .isLast(reviewList.isLast())
                .isFirst(reviewList.isFirst())
                .totalPage(reviewList.getTotalPages())
                .totalElements(reviewList.getTotalElements())
                .listSize(reviewPreViewDTOList.size())
                .reviewList(reviewPreViewDTOList)
                .build();
    }
}
