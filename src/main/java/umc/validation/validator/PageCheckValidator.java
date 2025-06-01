package umc.validation.validator;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import umc.apiPayload.code.status.ErrorStatus;
import umc.repository.location.LocationRepository;
import umc.validation.annotation.CheckPage;
import umc.validation.annotation.ExistLocation;

@Component
@RequiredArgsConstructor
public class PageCheckValidator implements ConstraintValidator<CheckPage, Integer> {

    @Override
    public void initialize(CheckPage constraintAnnotation) {
        ConstraintValidator.super.initialize(constraintAnnotation);
    }

    @Override
    public boolean isValid(Integer aInteger, ConstraintValidatorContext context) {

        boolean isValid = true;

        if(aInteger < 0){
            isValid = false;
        }

        return isValid;
    }
}
