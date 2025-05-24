package umc.study.service.foodcategory;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import umc.study.repository.foodcategory.FoodCategoryRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
public class FoodCategoryServiceImpl implements FoodCategoryService {
    private final FoodCategoryRepository foodCategoryRepository;

    @Override
    public boolean existsAllById(List<Long> ids) {
        return ids.stream().allMatch(foodCategoryRepository::existsById);
    }
}
