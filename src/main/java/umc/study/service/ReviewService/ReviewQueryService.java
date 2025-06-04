package umc.study.service.ReviewService;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import umc.study.domain.Review;
import umc.study.web.dto.Review.ReviewRequestDto;
import umc.study.web.dto.Review.ReviewResponseDto;

public interface ReviewQueryService {
    Page<ReviewResponseDto.JoinResultDTO> findUserReviews(Long memberId, Pageable pageable);
    Review registerReview(ReviewRequestDto.JoinDto request);
}
