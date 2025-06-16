package umc.service.ReviewService;

import org.springframework.data.domain.Page;

import umc.domain.Review;

public interface ReviewQueryService {
	Page<Review> getMyReviewList(Long restaurantId, Long userId, Integer page);
}
