package umc.study.service.FoodCategoryService;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import umc.study.repository.FoodCategoryRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
public class FoodCategoryCommandServiceImpl implements FoodCategoryCommandService {
    private final FoodCategoryRepository foodCategoryRepository;

    public boolean existsAllByIds(List<Long> ids) {
        return ids.stream().allMatch(foodCategoryRepository::existsById);
    }

}
