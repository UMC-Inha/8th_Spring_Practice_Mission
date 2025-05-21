package umc.repository.restaurant;

import org.springframework.data.jpa.repository.JpaRepository;
import umc.domain.RestaurantImage;

public interface RestaurantImageRepository extends JpaRepository<RestaurantImage, Long> {
}
