package umc.infrastructure.persistence.repository.review;

import umc.infrastructure.persistence.entity.review.Review;

public interface ReviewRepository {
    Review save(Review review);
}
