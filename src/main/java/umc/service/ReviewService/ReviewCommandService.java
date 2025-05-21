package umc.service.ReviewService;

import umc.domain.Review;
import umc.dto.ReviewRequestDto;

public interface ReviewCommandService {
	Review joinReview(ReviewRequestDto.JoinDto request);
}
