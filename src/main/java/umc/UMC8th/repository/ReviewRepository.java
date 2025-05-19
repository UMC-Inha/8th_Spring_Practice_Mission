package umc.UMC8th.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import umc.UMC8th.domain.Review;

public interface ReviewRepository extends JpaRepository<Review, Long> {
}
