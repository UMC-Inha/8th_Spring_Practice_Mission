package umc.infrastructure.persistence.repository.category;

import org.springframework.data.jpa.repository.JpaRepository;
import umc.infrastructure.persistence.entity.category.Category;

import java.util.List;

public interface JpaCategoryRepository extends JpaRepository<Category, Long> {


}
