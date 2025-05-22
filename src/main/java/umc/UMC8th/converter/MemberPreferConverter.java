package umc.UMC8th.converter;

import umc.UMC8th.domain.FoodCategories;
import umc.UMC8th.domain.mapping.MemberPrefer;

import java.util.List;
import java.util.stream.Collectors;

public class MemberPreferConverter {

    public static List<MemberPrefer> toMemberPreferList(List<FoodCategories> foodCategoryList) {
        return foodCategoryList.stream()
                .map(category -> MemberPrefer.builder()
                        .foodCategory(category)
                        .build())
                .collect(Collectors.toList());
    }
}
