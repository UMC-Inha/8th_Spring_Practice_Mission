package umc.repository.foodCategory;

import org.springframework.data.jpa.repository.JpaRepository;
import umc.domain.FoodCategory;

import java.util.Optional;

public interface FoodCategoryRepository extends JpaRepository<FoodCategory, Long> {
    Optional<FoodCategory> findById(Long id);
}
