package umc.common.validation.annotation;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;
import umc.common.validation.validator.ExistCategoriesValidator;
import umc.common.validation.validator.ExistStoreValidator;

import java.lang.annotation.*;

@Documented
@Constraint(validatedBy = ExistStoreValidator.class)
@Target( { ElementType.METHOD, ElementType.FIELD, ElementType.PARAMETER })
@Retention(RetentionPolicy.RUNTIME)
public @interface ExistStore {
    //어차피 optional로 가져올 거라 필요 없을듯?
    String message() default "해당하는 가게가 존재하지 않습니다.";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}
