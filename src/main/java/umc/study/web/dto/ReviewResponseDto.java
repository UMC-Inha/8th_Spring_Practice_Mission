package umc.study.web.dto;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Builder
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class ReviewResponseDto {
        Long reviewId;
        //String content;
        //BigDecimal rating;
        LocalDateTime createdAt;
}
