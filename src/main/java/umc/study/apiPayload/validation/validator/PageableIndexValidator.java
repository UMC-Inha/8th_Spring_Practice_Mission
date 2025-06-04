package umc.study.apiPayload.validation.validator;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import org.springframework.data.domain.Pageable;
import umc.study.apiPayload.validation.annotation.ValidPageableIndex;

public class PageableIndexValidator implements ConstraintValidator<ValidPageableIndex, Pageable> {
    @Override
    public boolean isValid(Pageable pageable, ConstraintValidatorContext context) {
        if (pageable == null) {
            return true;
        }
        int pageNumber = pageable.getPageNumber();
        return pageNumber >= 0;
    }
}