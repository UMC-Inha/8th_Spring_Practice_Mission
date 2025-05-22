package umc.UMC8th.dto;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Getter
@Builder
@AllArgsConstructor
public class CreateReviewResponse {
    private Long reviewId;
    private String title;
    private String reviewText;
    private BigDecimal rating;
    private LocalDateTime createdAt;
}
