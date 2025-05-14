package umc.repository.restaurantRepository;

import com.querydsl.core.BooleanBuilder;
import com.querydsl.core.types.dsl.NumberExpression;
import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import umc.domain.QRestaurant;
import umc.domain.Restaurant;

import java.util.List;

import static com.querydsl.core.types.dsl.Expressions.numberTemplate;

@Repository
@RequiredArgsConstructor
public class RestaurantRepositoryImpl implements RestaurantRepositoryCustom{
    private final JPAQueryFactory jpaQueryFactory;
    private final QRestaurant restaurant = QRestaurant.restaurant;

    @Override
    public List<Restaurant> dynamicQueryWithBooleanBuilder(String name, Float score){
        BooleanBuilder predicate = new BooleanBuilder();

        // eq: restaurant.name 과 name이 같은 값은 추출
        if(name!=null) predicate.and(restaurant.name.eq(name));

        // where 조건에 avgStar을 넣기 위해 NumberExpression을 사용해서 계산
        NumberExpression<Float> avgStar =
                numberTemplate(Float.class, "({0} * 1.0) / nullif({1}, 0)", restaurant.total_star, restaurant.review_count);

        // goe: avgStar가 4.0f 이상인 것을 추출
        if(score!=null) predicate.and(avgStar.goe(4.0f));

        return jpaQueryFactory
                .selectFrom(restaurant)
                .where(predicate)
                .fetch();
    }



}
