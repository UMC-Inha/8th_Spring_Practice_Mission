package umc.study.repository.food;

import org.springframework.data.jpa.repository.JpaRepository;
import umc.study.domain.category.Category;

public interface CategoryRepository extends JpaRepository<Category, Long> {
}
