package umc.study.apiPayload.validation.annotation;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;
import umc.study.apiPayload.validation.validator.UniqueMemberMissionValidator;

import java.lang.annotation.*;

@Documented
@Constraint(validatedBy = UniqueMemberMissionValidator.class)
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
public @interface UniqueMemberMission {
    String message() default "이미 미션에 도전중입니다.";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}
