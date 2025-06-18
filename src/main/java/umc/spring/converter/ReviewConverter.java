package umc.spring.converter;

import org.springframework.data.domain.Page;
import umc.spring.domain.Member;
import umc.spring.domain.Review;
import umc.spring.domain.Store;
import umc.spring.web.dto.review.ReviewRequestDTO;
import umc.spring.web.dto.review.ReviewResponseDTO;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

public class ReviewConverter {
    public static ReviewResponseDTO.CreateReviewResultDTO toWriteReviewResultDto (Review review) {
        return ReviewResponseDTO.CreateReviewResultDTO.builder()
                .reviewId(review.getId())
                .createdAt(LocalDateTime.now())
                .build();
    }

    public static Review toReview(ReviewRequestDTO.CreateReviewDTO request, Store store, Member member) {
        return Review.builder()
                .member(member)
                .content(request.getContent())
                .starRating(request.getStarRating())
                .store(store)
                .build();
    }

    public static ReviewResponseDTO.PreviewReviewDto previewReviewDto(Review review) {
        return ReviewResponseDTO.PreviewReviewDto.builder()
                .ownerNickname(review.getMember().getName())
                .starRating(review.getStarRating())
                .content(review.getContent())
                .createdAt(review.getCreatedAt().toLocalDate())
                .build();
    }

    public static ReviewResponseDTO.PreviewReviewListResultDto previewReviewListResultDto (Page<Review> reviewList) {

        List<ReviewResponseDTO.PreviewReviewDto> previewReviewDtoList = reviewList.getContent().stream()
                .map(ReviewConverter::previewReviewDto).collect(Collectors.toList());

        return ReviewResponseDTO.PreviewReviewListResultDto.builder()
                .isLast(reviewList.isLast())
                .isFirst(reviewList.isFirst())
                .totalPage(reviewList.getTotalPages())
                .totalElements(reviewList.getTotalElements())
                .listSize(previewReviewDtoList.size())
                .reviewList(previewReviewDtoList)
                .build();
    }

    public static ReviewResponseDTO.PreviewMyReviewDto previewMyReviewDto(Review review) {
        return ReviewResponseDTO.PreviewMyReviewDto.builder()
                .ownerNickname(review.getMember().getName())
                .starRating(review.getStarRating())
                .content(review.getContent())
                .createdAt(review.getCreatedAt().toLocalDate())
                .build();
    }

    public static ReviewResponseDTO.PreviewMyReviewListResultDto previewMyReviewListResultDto (Page<Review> reviewList) {

        List<ReviewResponseDTO.PreviewMyReviewDto> previewMyReviewDtoList = reviewList.getContent().stream()
                .map(ReviewConverter::previewMyReviewDto).collect(Collectors.toList());

        return ReviewResponseDTO.PreviewMyReviewListResultDto.builder()
                .isLast(reviewList.isLast())
                .isFirst(reviewList.isFirst())
                .totalPage(reviewList.getTotalPages())
                .totalElements(reviewList.getTotalElements())
                .listSize(previewMyReviewDtoList.size())
                .reviewList(previewMyReviewDtoList)
                .build();
    }
}
