package umc.repository.restaurant;

import org.springframework.data.jpa.repository.JpaRepository;
import umc.domain.RestaurantFood;

public interface RestaurantFoodRepository extends JpaRepository<RestaurantFood, Long> {
}
