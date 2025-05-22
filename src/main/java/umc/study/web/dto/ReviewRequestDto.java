package umc.study.web.dto;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import umc.study.validation.annotation.ExistStore;
import umc.study.validation.annotation.ExistUser;

import java.math.BigDecimal;

@Getter
public class ReviewRequestDto {
        @NotBlank
        private String content;

        @ExistStore
        private Long storeId;

        @ExistUser
        private Long userId;

        @NotNull
        @Min(0)
        @Max(5)
        private BigDecimal rating;
}
