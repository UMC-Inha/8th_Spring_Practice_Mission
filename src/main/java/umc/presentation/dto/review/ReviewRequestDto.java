package umc.presentation.dto.review;

import umc.common.validation.annotation.ExistStore;
import umc.common.validation.annotation.ExistUser;

public class ReviewRequestDto {
    public record CreateReviewRequestDto(@ExistStore Long storeId,
                                         @ExistUser Long userId,
                                         String content,
                                         String title,
                                         Integer score){}
}
