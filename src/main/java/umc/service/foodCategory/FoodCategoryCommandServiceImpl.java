package umc.service.foodCategory;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import umc.repository.foodCategory.FoodCategoryRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
public class FoodCategoryCommandServiceImpl implements FoodCategoryCommandService {

    private final FoodCategoryRepository foodCategoryRepository;


}
