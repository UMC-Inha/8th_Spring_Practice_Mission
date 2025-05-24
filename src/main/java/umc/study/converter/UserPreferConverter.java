package umc.study.converter;

import umc.study.domain.mapping.PreferFood;
import umc.study.domain.store.FoodCategory;

import java.util.List;
import java.util.stream.Collectors;

public class UserPreferConverter {
    public static List<PreferFood> toUserPreferList(List<FoodCategory> foodCategoryList) {

        return foodCategoryList.stream()
                .map(foodCategory ->
                        PreferFood.builder()
                                .category(foodCategory)
                                .build()
                ).collect(Collectors.toList());
    }
}

