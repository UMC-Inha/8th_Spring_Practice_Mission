package umc.infrastructure.persistence.repository.review;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import umc.infrastructure.persistence.entity.review.Review;

@Repository
@RequiredArgsConstructor
public class ReviewRepositoryImpl implements ReviewRepository{
    private final JpaReviewRepository jpaReviewRepository;

    public Review save(Review review) {
        return jpaReviewRepository.save(review);
    }
}
