package umc.study.repository.image;

import org.springframework.data.jpa.repository.JpaRepository;
import umc.study.domain.Image;

public interface ImageRepository extends JpaRepository<Image, Long> {
}
