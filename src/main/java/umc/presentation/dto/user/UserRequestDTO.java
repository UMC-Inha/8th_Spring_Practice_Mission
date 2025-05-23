package umc.presentation.dto.user;

import umc.common.validation.annotation.ExistCategories;
import umc.common.validation.annotation.ValidEnum;
import umc.infrastructure.persistence.entity.user.Gender;

import java.util.List;

public class UserRequestDTO {
    public record JoinDto(String name,
                          @ValidEnum(enumClass = Gender.class) String gender,
                          String address,
                          @ExistCategories List<Long> preferCategoryIdList){}
}
