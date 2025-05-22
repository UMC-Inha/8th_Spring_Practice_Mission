package umc.infrastructure.persistence.repository.category;

import umc.infrastructure.persistence.entity.category.Category;

import javax.swing.text.html.Option;
import java.util.List;
import java.util.Optional;

public interface CategoryRepository {
    boolean existsById(Long id);

    Optional<Category> findById(Long id);

    List<Category> findAllCategoryByIds(List<Long> ids);
}
