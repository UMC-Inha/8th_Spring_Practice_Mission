package umc.study.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import umc.study.domain.FoodType;

public interface FoodTypeRepository extends JpaRepository<FoodType, Long> {
}
