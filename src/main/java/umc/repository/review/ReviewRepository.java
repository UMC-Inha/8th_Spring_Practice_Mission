package umc.repository.review;

import org.springframework.data.jpa.repository.JpaRepository;
import umc.domain.Review;

public interface ReviewRepository extends JpaRepository<Review, Long> {
}
