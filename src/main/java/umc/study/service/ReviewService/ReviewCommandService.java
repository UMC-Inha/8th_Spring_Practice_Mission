package umc.study.service.ReviewService;

import umc.study.domain.Review;
import umc.study.web.dto.request.ReviewRequestDTO;

public interface ReviewCommandService {
    public Review save(Long storeId, ReviewRequestDTO.createReviewDto request);
}
