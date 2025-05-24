package umc.study.service.review;

import umc.study.domain.review.Review;
import umc.study.web.dto.request.ReviewRequestDto;

public interface ReviewCommandService {
    Review registerReview(ReviewRequestDto.RegisterDto request);
}
