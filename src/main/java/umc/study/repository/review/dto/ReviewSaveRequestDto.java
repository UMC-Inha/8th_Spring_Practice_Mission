package umc.study.repository.review.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import umc.study.domain.Image;

import java.util.List;

@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ReviewSaveRequestDto {
    private Long storeId;
    private Long memberId;
    private String body;
    private float score;
    private List<Image> imageList;
}
