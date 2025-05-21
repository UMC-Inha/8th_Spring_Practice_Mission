package umc.validation.validator;

import org.springframework.stereotype.Component;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import lombok.RequiredArgsConstructor;
import umc.apiPayload.code.status.ErrorStatus;
import umc.repository.CategoryRepository.CategoryRepository;
import umc.validation.annotation.ExistCategory;

@Component
@RequiredArgsConstructor
public class CategoryExistValidator implements ConstraintValidator<ExistCategory, Long> {

    private final CategoryRepository categoryRepository;

    @Override
    public boolean isValid(Long categoryId, ConstraintValidatorContext context) {
        boolean isValid = categoryRepository.existsById(categoryId);

        if (!isValid) {
            context.disableDefaultConstraintViolation();
            context.buildConstraintViolationWithTemplate(ErrorStatus.FOOD_CATEGORY_NOT_FOUND.toString()).addConstraintViolation();
        }

        return isValid;
    }
}
