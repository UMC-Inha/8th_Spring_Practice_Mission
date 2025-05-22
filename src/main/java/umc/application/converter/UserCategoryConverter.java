package umc.application.converter;

import umc.infrastructure.persistence.entity.category.Category;
import umc.infrastructure.persistence.entity.category.UserCategory;

import java.util.List;
import java.util.stream.Collectors;

public class UserCategoryConverter {
    public static List<UserCategory> toUserCategoryList(List<Category> foodCategoryList){
        return foodCategoryList.stream().map(foodCategory ->  UserCategory.builder().category(foodCategory).build())
                .collect(Collectors.toList());
    }
}
