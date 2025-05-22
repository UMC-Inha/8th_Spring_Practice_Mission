package umc.UMC8th.validation.validator;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import umc.UMC8th.repository.StoreRepository.StoreRepository;
import umc.UMC8th.validation.annotation.StoreExists;

@Component
@RequiredArgsConstructor
public class StoreExistValidator implements ConstraintValidator<StoreExists, Long> {

    private final StoreRepository storeRepository;

    @Override
    public boolean isValid(Long value, ConstraintValidatorContext context) {
        return value != null && storeRepository.existsById(value);
    }
}
