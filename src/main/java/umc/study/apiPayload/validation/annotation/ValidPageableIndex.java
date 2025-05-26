package umc.study.apiPayload.validation.annotation;


import jakarta.validation.Constraint;
import jakarta.validation.Payload;
import umc.study.apiPayload.validation.validator.PageableIndexValidator;

import java.lang.annotation.*;

@Documented
@Constraint(validatedBy = PageableIndexValidator.class)
@Target({ ElementType.PARAMETER })
@Retention(RetentionPolicy.RUNTIME)
public @interface ValidPageableIndex {
    String message() default "page 파라미터는 1 이상이어야 합니다.";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}
