package umc.application.converter;

import umc.infrastructure.persistence.entity.category.Category;
import umc.infrastructure.persistence.entity.category.UserCategory;
import umc.infrastructure.persistence.entity.category.UserCategoryPK;

import java.util.List;
import java.util.stream.Collectors;

public class UserCategoryConverter {
    public static List<UserCategory> toUserCategoryList(List<Category> categories) {
        return categories.stream()
                .map(category -> UserCategory.builder()
                        .id(new UserCategoryPK(null, category.getId())) // ★ id 미리 생성
                        .category(category)
                        .build())
                .collect(Collectors.toList());
    }
}
