package umc.UMC8th.service;

import umc.UMC8th.domain.Review;
import umc.UMC8th.dto.CreateReviewRequest;

public interface ReviewCommandService {
    Review createReview(CreateReviewRequest request);
}
