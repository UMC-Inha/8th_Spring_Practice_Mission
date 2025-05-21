package umc.repository.CategoryRepository;

import org.springframework.data.jpa.repository.JpaRepository;

import umc.domain.Category;

public interface CategoryRepository extends JpaRepository<Category, Long> {
}
