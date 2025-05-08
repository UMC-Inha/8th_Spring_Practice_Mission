package umc.repository.RestaurantRepository;

import umc.domain.Restaurant;

import java.util.List;

public interface RestaurantRepositoryCustom {
    List<Restaurant> dynamicQueryWithBooleanBuilder(String name, Double score);
}
