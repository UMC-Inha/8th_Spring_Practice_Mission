package umc.repository.review;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import umc.entity.review.Review;

@Repository
public interface JpaReviewRepository extends JpaRepository<Review, Long> {
}
