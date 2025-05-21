package umc.validation.validator;

import org.springframework.stereotype.Component;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import lombok.RequiredArgsConstructor;
import umc.apiPayload.code.status.ErrorStatus;
import umc.repository.RestaurantRepository.RestaurantRepository;
import umc.validation.annotation.ExistRestaurant;

@Component
@RequiredArgsConstructor
public class RestaurantExistValidator implements ConstraintValidator<ExistRestaurant, Long> {

    private final RestaurantRepository restaurantRepository;

    @Override
    public boolean isValid(Long restaurantId, ConstraintValidatorContext context) {
        boolean isValid = restaurantRepository.existsById(restaurantId);

        if (!isValid) {
            context.disableDefaultConstraintViolation();
            context.buildConstraintViolationWithTemplate(ErrorStatus.RESTAURANT_NOT_FOUND.toString()).addConstraintViolation();
        }

        return isValid;
    }
}
