package umc.study.repository.foodcategory;

import org.springframework.data.jpa.repository.JpaRepository;
import umc.study.domain.store.FoodCategory;

public interface FoodCategoryRepository extends JpaRepository<FoodCategory, Long>{

}
