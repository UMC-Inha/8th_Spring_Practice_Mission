package umc.UMC8th.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class CreateReviewRequest {
    private Long memberId;
    private Long storeId;
    private String title;
    private String reviewText;
    private BigDecimal rating;
}
