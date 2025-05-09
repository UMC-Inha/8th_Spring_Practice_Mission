package umc.study.repository.review;

import org.springframework.data.jpa.repository.JpaRepository;
import umc.study.domain.review.Review;

public interface ReviewRepository extends JpaRepository<Review, Long> {
}
