package umc.study.service.ReviewService;

import umc.study.domain.Review;
import umc.study.web.dto.Review.ReviewRequestDto;

public interface ReviewQueryService {
    Review registerReview(ReviewRequestDto.JoinDto request);
}
