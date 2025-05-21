package umc.repository.review;

import org.springframework.data.jpa.repository.JpaRepository;
import umc.domain.ReviewImage;

public interface ReviewImageRepository extends JpaRepository<ReviewImage, Long> {
}
