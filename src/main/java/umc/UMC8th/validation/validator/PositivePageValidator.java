package umc.UMC8th.validation.validator;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import org.springframework.stereotype.Component;
import umc.UMC8th.validation.annotation.PositivePage;

@Component
public class PositivePageValidator implements ConstraintValidator<PositivePage, Integer> {

    @Override
    public boolean isValid(Integer value, ConstraintValidatorContext context) {
        return value != null && value > 0;
    }
}
