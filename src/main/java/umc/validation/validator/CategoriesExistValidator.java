package umc.validation.validator;

import java.util.List;

import org.springframework.stereotype.Component;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import lombok.RequiredArgsConstructor;
import umc.apiPayload.code.status.ErrorStatus;
import umc.repository.CategoryRepository.CategoryRepository;
import umc.validation.annotation.ExistCategories;

@Component
@RequiredArgsConstructor
public class CategoriesExistValidator implements ConstraintValidator<ExistCategories, List<Long>> {

	private final CategoryRepository categoryRepository;

	@Override
	public void initialize(ExistCategories constraintAnnotation) {
		ConstraintValidator.super.initialize(constraintAnnotation);
	}

	@Override
	public boolean isValid(List<Long> values, ConstraintValidatorContext context) {
		boolean isValid = values.stream()
			.allMatch(value -> categoryRepository.existsById(value));

		if (!isValid) {
			context.disableDefaultConstraintViolation();
			context.buildConstraintViolationWithTemplate(ErrorStatus.FOOD_CATEGORY_NOT_FOUND.toString()).addConstraintViolation();
		}

		return isValid;
	}
}
