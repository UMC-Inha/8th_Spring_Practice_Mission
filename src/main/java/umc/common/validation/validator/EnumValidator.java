package umc.common.validation.validator;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import lombok.NonNull;
import umc.common.validation.annotation.ValidEnum;

import java.util.Arrays;
import java.util.Set;
import java.util.stream.Collectors;

public class EnumValidator implements ConstraintValidator<ValidEnum, String> {

    private Set<String> allowedValues;
    private boolean ignoreCase;

    @Override
    public void initialize(@NonNull ValidEnum constraintAnnotation) {
        Class<? extends Enum<?>> enumClass = constraintAnnotation.enumClass();
        ignoreCase = constraintAnnotation.ignoreCase();
        allowedValues = Arrays.stream(enumClass.getEnumConstants())
                .map(e -> ignoreCase ? e.name().toLowerCase() : e.name())
                .collect(Collectors.toSet());
    }

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        if (value.isEmpty() || value.trim().isEmpty()) {
            return true;
        }
        return allowedValues.contains(ignoreCase ? value.toLowerCase() : value);
    }
}
