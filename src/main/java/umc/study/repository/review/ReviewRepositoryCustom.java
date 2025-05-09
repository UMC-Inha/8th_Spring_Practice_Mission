package umc.study.repository.review;

import umc.study.domain.review.Review;
import umc.study.repository.review.dto.ReviewSaveRequestDto;

public interface ReviewRepositoryCustom {
    Review saveReviewByMemberIdAndStoreId(ReviewSaveRequestDto requestDto);
}
