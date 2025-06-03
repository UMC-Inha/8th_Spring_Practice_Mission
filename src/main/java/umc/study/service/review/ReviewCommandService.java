package umc.study.service.review;

import org.springframework.data.domain.Slice;
import umc.study.domain.review.Review;
import umc.study.web.dto.request.ReviewRequestDto;

public interface ReviewCommandService {
    Review registerReview(ReviewRequestDto.RegisterDto request);

    Slice<Review> findUserReviewList(Long userId, Integer page, Integer size);
}
