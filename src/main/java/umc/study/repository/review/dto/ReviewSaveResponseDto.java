package umc.study.repository.review.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import umc.study.domain.Image;
import umc.study.domain.review.Review;

import java.math.BigDecimal;
import java.util.List;
import java.util.stream.Collectors;

@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ReviewSaveResponseDto {
    private String body;
    private BigDecimal score;
    private List<String> imageList;

    public static ReviewSaveResponseDto EntityToDto(Review review) {
        return ReviewSaveResponseDto.builder()
                .body(review.getBody())
                .score(review.getScore())
                .imageList(review.getImageList())
                .build();
    }
}
