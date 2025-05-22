package umc.infrastructure.persistence.repository.category;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import umc.infrastructure.persistence.entity.category.Category;

import java.util.List;
import java.util.Optional;

@Repository
@RequiredArgsConstructor
public class CategoryRepositoryImpl implements CategoryRepository{
    private final JpaCategoryRepository jpaCategoryRepository;

    @Override
    public boolean existsById(Long id) {
        return jpaCategoryRepository.existsById(id);
    }

    @Override
    public Optional<Category> findById(Long id) {
        return jpaCategoryRepository.findById(id);
    }
    @Override
    public List<Category> findAllCategoryByIds(List<Long> ids){
        return jpaCategoryRepository.findAllById(ids);
    }
}
