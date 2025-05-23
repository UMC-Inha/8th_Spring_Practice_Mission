package umc.common.validation.validator;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import umc.common.ApiPayload.code.status.ErrorStatus;
import umc.common.validation.annotation.ExistCategories;
import umc.infrastructure.persistence.repository.store.StoreRepository;


@Component
@RequiredArgsConstructor
public class ExistStoreValidator implements ConstraintValidator<ExistCategories, Long> {
    private final StoreRepository storeRepository;

    @Override
    public void initialize(ExistCategories constraintAnnotation) {
        ConstraintValidator.super.initialize(constraintAnnotation);
    }

    @Override
    public boolean isValid(Long storeId, ConstraintValidatorContext context) {
        boolean isValid = storeRepository.existsById(storeId);

        if (!isValid) {
            context.disableDefaultConstraintViolation();
            context.buildConstraintViolationWithTemplate(ErrorStatus.STORE_NOT_FOUND.toString()).addConstraintViolation();
        }

        return isValid;
    }
}
