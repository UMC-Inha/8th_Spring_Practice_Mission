package umc.validation.validator;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import umc.apiPayload.code.status.ErrorStatus;
import umc.repository.foodCategory.FoodCategoryRepository;
import umc.repository.location.LocationRepository;
import umc.validation.annotation.ExistLocation;

import java.util.List;

@Component
@RequiredArgsConstructor
public class LocationExistValidator implements ConstraintValidator<ExistLocation, Long> {

    private final LocationRepository locationRepository;

    @Override
    public void initialize(ExistLocation constraintAnnotation) {
        ConstraintValidator.super.initialize(constraintAnnotation);
    }

    @Override
    public boolean isValid(Long aLong, ConstraintValidatorContext context) {

        boolean isValid;


        isValid = locationRepository.existsById(aLong);



        if (!isValid) {
            context.disableDefaultConstraintViolation();
            context.buildConstraintViolationWithTemplate(ErrorStatus.LOCATION_NOT_FOUND.toString()).addConstraintViolation();
        }

        return isValid;
    }
}
