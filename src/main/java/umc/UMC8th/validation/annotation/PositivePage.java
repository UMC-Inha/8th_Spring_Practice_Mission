package umc.UMC8th.validation.annotation;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;
import umc.UMC8th.validation.validator.PositivePageValidator;

import java.lang.annotation.*;

@Documented
@Constraint(validatedBy = PositivePageValidator.class)
@Target({ElementType.PARAMETER})
@Retention(RetentionPolicy.RUNTIME)
public @interface PositivePage {
    String message() default "페이지 번호는 1 이상이어야 합니다.";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}
