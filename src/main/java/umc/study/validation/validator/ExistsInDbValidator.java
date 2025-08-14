package umc.study.validation.validator;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.data.jpa.repository.JpaRepository;
import umc.study.validation.annotation.ExistsInDb;

public class ExistsInDbValidator implements ConstraintValidator<ExistsInDb, Long>, ApplicationContextAware {
    private ApplicationContext ctx;
    private JpaRepository<?, Long> repository;
    private String messageTemplate;

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) {
        this.ctx = applicationContext;
    }

    @Override
    public void initialize(ExistsInDb anno) {
        this.repository = ctx.getBean(anno.repository());
        this.messageTemplate = anno.message();
    }

    @Override
    public boolean isValid(Long value, ConstraintValidatorContext context) {
        if (value == null) return true;
        boolean exists = repository.existsById(value);
        if (!exists) {
            context.disableDefaultConstraintViolation();
            context.buildConstraintViolationWithTemplate(messageTemplate)
                    .addConstraintViolation();
        }
        return exists;
    }
}
