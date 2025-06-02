package umc.converter.review;

import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import umc.domain.Member;
import umc.domain.Restaurant;
import umc.domain.Review;
import umc.dto.review.ReviewRequestDTO;
import umc.dto.review.ReviewResponseDTO;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Slf4j
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

    public static ReviewResponseDTO.PreviewReviewDto previewReviewDto(Review review) {
        return ReviewResponseDTO.PreviewReviewDto.builder()
                .ownerNickname(review.getMember().getName())
                .score(review.getScore())
                .content(review.getContent())
                .createdAt(review.getCreatedAt().toLocalDate())
                .build();
    }

    public static ReviewResponseDTO.PreviewReviewListResultDto previewReviewListResultDto (Page<Review> reviewPage) {

        List<ReviewResponseDTO.PreviewReviewDto> previewReviewDtoList = reviewPage.getContent().stream()
                .map(ReviewConverter::previewReviewDto).collect(Collectors.toList());

        return ReviewResponseDTO.PreviewReviewListResultDto.builder()
                .reviewList(previewReviewDtoList)
                .isFirst(reviewPage.isFirst())
                .isLast(reviewPage.isLast())
                .listSize(previewReviewDtoList.size())
                .totalElements(reviewPage.getTotalElements())
                .totalPage(reviewPage.getTotalPages())
                .build();
    }

    public static ReviewResponseDTO.PreviewMyReviewDto previewMyReviewDto(Review review) {
        return ReviewResponseDTO.PreviewMyReviewDto.builder()
                .restaurantName(review.getRestaurant().getName())
                .score(review.getScore())
                .content(review.getContent())
                .createdAt(review.getCreatedAt().toLocalDate())
                .build();
    }

    public static ReviewResponseDTO.PreviewMyReviewListResultDto previewMyReviewListResultDto (Page<Review> reviewPage) {

        List<ReviewResponseDTO.PreviewMyReviewDto> previewMyReviewDtoList = reviewPage.getContent().stream()
                .map(ReviewConverter::previewMyReviewDto).toList();

        return ReviewResponseDTO.PreviewMyReviewListResultDto.builder()
                .reviewList(previewMyReviewDtoList)
                .isFirst(reviewPage.isFirst())
                .isLast(reviewPage.isLast())
                .listSize(previewMyReviewDtoList.size())
                .totalElements(reviewPage.getTotalElements())
                .totalPage(reviewPage.getTotalPages())
                .build();
    }
}
