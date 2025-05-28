package umc.application.service.review;

import org.springframework.data.domain.Page;
import umc.infrastructure.persistence.entity.review.Review;

public interface ReviewQueryService {
    Page<Review> getReviewList(Long StoreId, Integer page);

}
