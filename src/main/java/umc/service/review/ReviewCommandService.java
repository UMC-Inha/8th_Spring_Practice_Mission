package umc.service.review;

import jakarta.validation.Valid;
import umc.web.dto.review.ReviewRequestDTO;

public interface ReviewCommandService {
    void createReview(ReviewRequestDTO.createReviewDTO request, Long restaurantId);
}
