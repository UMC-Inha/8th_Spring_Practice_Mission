package umc.common.validation.annotation;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;
import umc.common.validation.validator.ExistCategoriesValidator;

import java.lang.annotation.*;

@Documented
@Constraint(validatedBy = ExistCategoriesValidator.class)
@Target( { ElementType.METHOD, ElementType.FIELD, ElementType.PARAMETER,
        ElementType.RECORD_COMPONENT,
        ElementType.TYPE_USE
})
@Retention(RetentionPolicy.RUNTIME)
public @interface ExistCategories {

    String message() default "해당하는 카테고리가 존재하지 않습니다.";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}