package umc.dto.review;

import jakarta.validation.constraints.NotNull;
import lombok.Getter;

public class ReviewRequestDTO {

    @Getter
    public static class WriteReviewDto {
        @NotNull
        Long memberId;
        @NotNull
        String content;
        @NotNull
        Double score;
    }

}
