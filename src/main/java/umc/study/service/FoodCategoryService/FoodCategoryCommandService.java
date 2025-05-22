package umc.study.service.FoodCategoryService;

import java.util.List;

public interface FoodCategoryCommandService {
    boolean existsAllByIds(List<Long> id);
}
