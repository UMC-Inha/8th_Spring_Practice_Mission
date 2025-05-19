package umc.study.web.dto.Review;

import jakarta.validation.constraints.NotBlank;

import lombok.Getter;
import umc.study.apiPayload.validation.annotation.ExistMember;
import umc.study.apiPayload.validation.annotation.ExistStore;

import java.util.List;

public class ReviewRequestDto {
    @Getter
    public static class JoinDto {
        @NotBlank
        String title;

        Float score;

        @ExistMember
        Long memberId;

        @ExistStore
        Long storeId;

        List<String> imgaeUrlList;
    }
}
