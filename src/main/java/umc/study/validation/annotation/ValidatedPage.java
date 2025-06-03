package umc.study.validation.annotation;

import jakarta.validation.Payload;

import java.lang.annotation.*;

@Target(ElementType.PARAMETER)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface ValidatedPage {
    String message() default "유효하지 않은 페이지 요청 번호입니다";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}
