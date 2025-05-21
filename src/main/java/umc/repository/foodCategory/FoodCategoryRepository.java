package umc.repository.foodCategory;

import org.springframework.data.jpa.repository.JpaRepository;
import umc.domain.FoodCategory;

public interface FoodCategoryRepository extends JpaRepository<FoodCategory, Long> {
}
