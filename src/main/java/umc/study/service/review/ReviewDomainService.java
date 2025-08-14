package umc.study.service.review;

import umc.study.repository.review.dto.ReviewSaveResponseDto;
import umc.study.repository.review.dto.ReviewSaveRequestDto;

public interface ReviewDomainService {
    ReviewSaveResponseDto saveReview(ReviewSaveRequestDto reviewRequestDto);
}
