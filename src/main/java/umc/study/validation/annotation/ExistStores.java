package umc.study.validation.annotation;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;
import umc.study.validation.validator.StoresExistValidator;

import java.lang.annotation.*;

@Documented // 사용자 정의 어노테이션 만드는 경우
@Constraint(validatedBy = StoresExistValidator.class)
@Target( { ElementType.METHOD, ElementType.FIELD, ElementType.PARAMETER }) // 어노테이션 적용 범위 지정
@Retention(RetentionPolicy.RUNTIME) // 실행하는 동안만 어노테이션 유효
public @interface ExistStores {
    String message() default "해당하는 가게가 존재하지 않습니다.";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}
