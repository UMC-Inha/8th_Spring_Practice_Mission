package umc.validation.validator;

import org.springframework.stereotype.Component;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import lombok.RequiredArgsConstructor;
import umc.apiPayload.code.status.ErrorStatus;
import umc.repository.UserRepository.UserRepository;
import umc.validation.annotation.ExistUser;

@Component
@RequiredArgsConstructor
public class UserExistValidator implements ConstraintValidator<ExistUser, String> {

    private final UserRepository userRepository;

    @Override
    public boolean isValid(String email, ConstraintValidatorContext context) {
        boolean isValid = userRepository.existsByEmail(email);

        if (!isValid) {
            context.disableDefaultConstraintViolation();
            context.buildConstraintViolationWithTemplate(ErrorStatus.USER_NOT_FOUND.toString()).addConstraintViolation();
        }

        return isValid;
    }
}
