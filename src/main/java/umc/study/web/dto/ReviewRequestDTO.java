package umc.study.web.dto;

import jakarta.validation.constraints.*;
import lombok.Getter;

import java.math.BigDecimal;
import java.util.List;

public class ReviewRequestDTO {
    @Getter
    public static class createReviewDto {
        @NotNull
        @DecimalMin("0.0")
        @DecimalMax("5.0")
        BigDecimal score;
        @NotBlank
        String body;
        List<@NotBlank @Size(max = 255) String> imageUrls;
    }
}
