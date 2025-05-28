package umc.converter.preferCategory;

import umc.domain.FoodCategory;
import umc.domain.Member;
import umc.domain.mapping.PreferCategory;

import java.util.List;

public class PreferCategoryConverter {

    public static List<PreferCategory> toPreferCategoryList (Member member, List<FoodCategory> foodCategoryList) {

        return foodCategoryList.stream()
                .map(foodCategory -> {
                    return PreferCategory.builder()
                            .member(member)
                            .foodCategory(foodCategory)
                            .build();
                }).toList();
    }
}
