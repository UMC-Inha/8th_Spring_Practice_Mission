package umc.repository.RestaurantRepository;

import org.springframework.data.jpa.repository.JpaRepository;
import umc.domain.Restaurant;

public interface RestaurantRepository extends JpaRepository<Restaurant, Long>, RestaurantRepositoryCustom {
}
