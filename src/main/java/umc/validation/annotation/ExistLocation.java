package umc.validation.annotation;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;
import umc.validation.validator.LocationExistValidator;

import java.lang.annotation.*;

@Documented
@Constraint(validatedBy = LocationExistValidator.class)
@Target( { ElementType.METHOD, ElementType.FIELD, ElementType.PARAMETER })
@Retention(RetentionPolicy.RUNTIME)
public @interface ExistLocation {

    String message() default "해당하는 위치 정보가 존재하지 않습니다.";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}