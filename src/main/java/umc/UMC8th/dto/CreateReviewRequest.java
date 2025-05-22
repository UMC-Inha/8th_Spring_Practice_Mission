package umc.UMC8th.dto;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class CreateReviewRequest {
    // private Long memberId; => 현재 미션에서 하드코딩으로 하기
    // private Long storeId;  => 현재 미션에서 하드코딩으로 하기
    private String title;
    @NotBlank
    private String reviewText;

    @NotNull
    @Min(1)
    @Max(5)
    private BigDecimal rating;
}
