package umc.study.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import umc.study.domain.ReviewPicture;

public interface ReviewPictureRepository extends JpaRepository<ReviewPicture, Long> {
}

