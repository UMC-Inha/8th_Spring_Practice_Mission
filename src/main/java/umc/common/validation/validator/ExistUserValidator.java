package umc.common.validation.validator;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import umc.common.ApiPayload.code.status.ErrorStatus;
import umc.common.validation.annotation.ExistCategories;
import umc.infrastructure.persistence.repository.user.UserRepository;

@Component
@RequiredArgsConstructor
public class ExistUserValidator implements ConstraintValidator<ExistCategories, Long> {
    private final UserRepository userRepository;

    @Override
    public void initialize(ExistCategories constraintAnnotation) {
        ConstraintValidator.super.initialize(constraintAnnotation);
    }

    @Override
    public boolean isValid(Long userId, ConstraintValidatorContext context) {
        boolean isValid = userRepository.existsById(userId);

        if (!isValid) {
            context.disableDefaultConstraintViolation();
            context.buildConstraintViolationWithTemplate(ErrorStatus.USER_NOT_FOUND.toString()).addConstraintViolation();
        }

        return isValid;
    }
}
