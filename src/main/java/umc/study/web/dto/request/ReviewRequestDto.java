package umc.study.web.dto.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;
import umc.study.validation.annotation.ExistCategories;
import umc.study.validation.annotation.ExistStore;

import java.math.BigDecimal;

public class ReviewRequestDto {


    @Getter
    @Setter
    public static class UserReviewListRequest {
        @NotNull
        private Long userId;
        private Integer page;
        private Integer size;
    }


    @Getter
    @Setter
    public static class RegisterDto{

        @NotNull
        @ExistStore
        private Long storeId;

        @NotNull
        private Long userId;

        @NotBlank(message = "리뷰 내용은 필수입니다.")
        private String reviewContent;

        @NotNull
        private BigDecimal score;

        private String imageUrl;
    }
}
