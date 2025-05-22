package umc.study.validation.validator;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import umc.study.apiPayload.code.status.ErrorStatus;
import umc.study.repository.FoodTypeRepository;
import umc.study.validation.annotation.ExistTypes;

import java.util.List;

@Component
@RequiredArgsConstructor
public class TypesExistValidator implements ConstraintValidator<ExistTypes, List<Long>> { //ExistTypes 어노테이션에 대한 로직을 담고, 검증 대상은 List<Long>이다

    //TODO: 리포지토리에 접근하는 계층은 무조건 서비스 하나만 있어야 한다.
    private final FoodTypeRepository foodTypeRepository;

    @Override
    public void initialize(ExistTypes constraintAnnotation) {
        ConstraintValidator.super.initialize(constraintAnnotation);
    }

    @Override
    public boolean isValid(List<Long> values, ConstraintValidatorContext context) {
        boolean isValid = values.stream()
                .allMatch(value -> foodTypeRepository.existsById(value));

        if (!isValid) {
            context.disableDefaultConstraintViolation();
            context.buildConstraintViolationWithTemplate(ErrorStatus.FOOD_TYPE_NOT_FOUND.toString()).addConstraintViolation();
        }

        return isValid;

    }
}