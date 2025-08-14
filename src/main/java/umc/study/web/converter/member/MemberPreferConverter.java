package umc.study.web.converter.member;

import umc.study.domain.category.Category;
import umc.study.domain.mapping.MemberCategory;
import umc.study.domain.member.Member;

import java.util.List;
import java.util.stream.Collectors;

public class MemberPreferConverter {
    public static List<MemberCategory> toMemberPreferList(Member member, List<Category> foodCategoryList) {
        return foodCategoryList.stream()
                .map(foodCategory -> MemberCategory.builder()
                        .member(member)
                        .category(foodCategory)
                        .build())
                .collect(Collectors.toList());
    }
}
