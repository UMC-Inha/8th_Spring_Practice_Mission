package umc.spring.web.dto.review;

import jakarta.validation.constraints.NotNull;
import lombok.Getter;

import java.math.BigDecimal;

public class ReviewRequestDTO {

    @Getter
    public static class CreateReviewDTO{
        @NotNull
        Long memberId;
        @NotNull
        String content;
        BigDecimal starRating;
    }
}
