package umc.study.validation.annotation;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;
import umc.study.validation.validator.TypesExistValidator;

import java.lang.annotation.*;

@Documented //사용자 정의 어노테이션 생성
@Constraint(validatedBy = TypesExistValidator.class) //validation을 커스텀 어노테이션을 통해 할 수 있도록 제공
@Target({ElementType.METHOD, ElementType.FIELD, ElementType.PARAMETER}) //어노테이션의 적용 범위 지정
@Retention(RetentionPolicy.RUNTIME) //어노테이션의 생명 주기 지정 -> RUNTIME 동안만 유효
public @interface ExistTypes {

    String message() default "해당하는 음식 타입이 존재하지 않습니다.";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}