package umc.UMC8th.validation.annotation;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;
import umc.UMC8th.validation.validator.NotDuplicatedMissionValidator;

import java.lang.annotation.*;

@Documented
@Constraint(validatedBy = NotDuplicatedMissionValidator.class)
@Target({ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
public @interface NotDuplicatedMission {
    String message() default "이미 도전 중인 미션입니다.";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}
