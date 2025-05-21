package umc.validation.annotation;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;
import umc.validation.validator.RestaurantExistValidator;
import umc.validation.validator.UserExistValidator;

import java.lang.annotation.*;

@Documented
@Constraint(validatedBy = UserExistValidator.class)
@Target( { ElementType.METHOD, ElementType.FIELD, ElementType.PARAMETER })
@Retention(RetentionPolicy.RUNTIME)
public @interface ExistUser {

    String message() default "해당하는 유저가 존재하지 않습니다.";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}