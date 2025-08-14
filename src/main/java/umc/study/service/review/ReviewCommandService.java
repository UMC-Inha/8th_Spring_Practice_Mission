package umc.study.service.review;

import umc.study.domain.review.Review;
import umc.study.web.controller.review.dto.ReviewRequestDTO;

public interface ReviewCommandService {
    public Review addReview(ReviewRequestDTO.AddDto addDto);
}
