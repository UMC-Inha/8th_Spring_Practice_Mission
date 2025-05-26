package umc.study.apiPayload.validation.validator;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import umc.study.apiPayload.validation.annotation.CheckPageable;

public class PageIndexValidator implements ConstraintValidator<CheckPageable, Integer> {
    @Override
    public boolean isValid(Integer value, ConstraintValidatorContext context) {
        return value != null && value >= 1;
    }
}