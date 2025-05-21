package umc.converter;

import umc.domain.FoodCategory;
import umc.domain.mapping.UserPreference;

import java.util.List;
import java.util.stream.Collectors;

public class UserPreferenceConverter {

    public static List<UserPreference> toUserPreferenceList(List<FoodCategory> foodCategoryList){

        return foodCategoryList.stream()
                .map(foodCategory ->
                        UserPreference.builder()
                                .foodCategory(foodCategory)
                                .build()
                ).collect(Collectors.toList());
    }
}

