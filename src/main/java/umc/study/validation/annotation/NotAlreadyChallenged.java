package umc.study.validation.annotation;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;
import umc.study.validation.validator.NotAlreadyChallengedValidator;
import java.lang.annotation.*;

@Documented // 사용자 정의 어노테이션 만드는 경우
@Constraint(validatedBy = NotAlreadyChallengedValidator.class)
@Target( { ElementType.TYPE}) // 어노테이션 적용 범위 지정
@Retention(RetentionPolicy.RUNTIME) // 실행하는 동안만 어노테이션 유효
public @interface NotAlreadyChallenged {
    String message() default "이미 도전 중인 미션입니다.";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}
