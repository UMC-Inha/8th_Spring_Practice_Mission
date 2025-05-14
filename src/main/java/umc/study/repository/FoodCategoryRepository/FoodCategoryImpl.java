package umc.study.repository.FoodCategoryRepository;

import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import umc.study.domain.QFoodCategory;

@Repository
@RequiredArgsConstructor
public class FoodCategoryImpl implements FoodCategoryRepositoryCustom {
    private final JPAQueryFactory jpaQueryFactory;
    private final QFoodCategory foodCategory = QFoodCategory.foodCategory;
}
