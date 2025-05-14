package umc.study.service.ReviewService;

import org.springframework.data.domain.Page;
import umc.study.domain.Review;

import java.util.List;

public interface ReviewQueryService {
    Page<Review> findReview(long id);
    List<Review> findReviewsByStore(long id);
}
