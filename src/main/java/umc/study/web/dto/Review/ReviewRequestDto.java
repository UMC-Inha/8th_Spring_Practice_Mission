package umc.study.web.dto.Review;

import jakarta.validation.constraints.NotBlank;

import lombok.Getter;

import java.util.List;

public class ReviewRequestDto {
    @Getter
    public static class JoinDto {
        @NotBlank
        String title;

        Float score;

        @NotBlank
        Long memberId;

        @NotBlank
        Long storeId;

        List<String> imgaeUrlList;
    }
}
