package umc.study.validation.annotation;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;
import org.springframework.data.jpa.repository.JpaRepository;
import umc.study.validation.validator.ExistsInDbValidator;

import java.lang.annotation.*;

@Documented
@Constraint(validatedBy = ExistsInDbValidator.class)
@Target({ElementType.FIELD, ElementType.PARAMETER, ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
public @interface ExistsInDb {
    String message() default "존재하지 않는 데이터입니다.";
    Class<?> [] groups() default {};
    Class<? extends Payload>[] payload() default {};
    Class<? extends JpaRepository<?, Long>> repository();
}
