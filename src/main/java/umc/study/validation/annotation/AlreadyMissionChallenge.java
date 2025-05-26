package umc.study.validation.annotation;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;
import umc.study.validation.validator.MissionAlreadyChallengeValidator;

import java.lang.annotation.*;

@Documented
@Constraint(validatedBy = MissionAlreadyChallengeValidator.class)
@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
public @interface AlreadyMissionChallenge {
    String message() default "해당 미션은 이미 도전 중인 미션입니다.";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
