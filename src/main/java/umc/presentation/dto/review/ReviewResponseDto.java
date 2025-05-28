package umc.presentation.dto.review;

import lombok.Builder;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

public class ReviewResponseDto {
    @Builder
    public record CreateReviewResponseDto(Long reviewId){ }

    @Builder
    public record ReviewPreviewListDto(List<ReviewPreviewDto> reviewList,
                                       Integer listSize,
                                       Integer totalPage,
                                       Long totalElements,
                                       Boolean isFirst,
                                       Boolean isLast){}

    @Builder
    public record ReviewPreviewDto( String ownerNickname,
                                    Integer score,
                                    String body,
                                    LocalDateTime createdAt){}
}
