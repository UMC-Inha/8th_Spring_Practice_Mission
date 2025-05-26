package umc.study.apiPayload.validation.annotation;


import jakarta.validation.Constraint;
import jakarta.validation.Payload;
import umc.study.apiPayload.validation.validator.PageIndexValidator;

import java.lang.annotation.*;

@Documented
@Constraint(validatedBy = PageIndexValidator.class)
@Target({ ElementType.PARAMETER, ElementType.FIELD })
@Retention(RetentionPolicy.RUNTIME)
public @interface CheckPageable {
    String message() default "page 파라미터는 1 이상의 정수여야 합니다.";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}
