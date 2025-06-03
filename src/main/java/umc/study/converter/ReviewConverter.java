package umc.study.converter;

import org.springframework.data.domain.Slice;
import umc.study.domain.review.Review;
import umc.study.domain.store.Store;
import umc.study.domain.user.User;
import umc.study.web.dto.request.ReviewRequestDto;
import umc.study.web.dto.response.ReviewResponseDto;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

public class ReviewConverter {


    public static Review toReview(ReviewRequestDto.RegisterDto request, User user, Store store){
        return Review.builder()
                .user(user)
                .store(store)
                .reviewContent(request.getReviewContent())
                .score(request.getScore())
                .imageUrl(request.getImageUrl())
                .build();
    }

    public static ReviewResponseDto.UserReviewListResult toUserReviewResultDto(Slice<Review> reviewSlice) {
        List<ReviewResponseDto.UserReviewDto> reviewDtoList = reviewSlice.stream()
                .map(review -> ReviewResponseDto.UserReviewDto.builder()
                        .reviewId(review.getId())
                        .storeName(review.getStore().getStoreName())
                        .content(review.getReviewContent())
                        .score(review.getScore())
                        .createdAt(review.getCreatedAt())
                        .build())
                .collect(Collectors.toList());

        return ReviewResponseDto.UserReviewListResult.builder()
                .reviews(reviewDtoList)
                .hasNext(reviewSlice.hasNext())
                .build();
    }

    public static ReviewResponseDto.RegisterResultDto toReviewRegisterResultDto(Review review) {
        return ReviewResponseDto.RegisterResultDto.builder()
                .id(review.getId())
                .userId(review.getUser().getId())
                .storeName(review.getStore().getStoreName())
                .reviewContent(review.getReviewContent())
                .createdAt(LocalDate.now())
                .build();
    }
}
