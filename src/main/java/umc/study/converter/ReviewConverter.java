package umc.study.converter;

import umc.study.domain.Review;
import umc.study.domain.Store;
import umc.study.domain.User;
import umc.study.web.dto.ReviewRequestDto;
import umc.study.web.dto.ReviewResponseDto;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class ReviewConverter {
    public static Review toEntity(ReviewRequestDto dto, User user, Store store) {
        return Review.builder()
                .content(dto.getContent())
                .rating(dto.getRating())
                .store(store)
                .user(user)
                .build();
    }

    public static ReviewResponseDto toResultDto(Review review) {
        return ReviewResponseDto.builder()
                .reviewId(review.getId())
                .createdAt(review.getCreatedAt())
                .build();
    }
}