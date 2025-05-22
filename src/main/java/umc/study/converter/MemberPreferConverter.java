package umc.study.converter;

import umc.study.domain.FoodType;
import umc.study.domain.mapping.MemberPrefer;

import java.util.List;
import java.util.stream.Collectors;

public class MemberPreferConverter {

    public static List<MemberPrefer> toMemberPreferList(List<FoodType> foodTypeList) {

        return foodTypeList.stream()
                .map(foodCategory ->
                        MemberPrefer.builder()
                                .foodType(foodCategory)
                                .build()
                ).collect(Collectors.toList());
    }
}
