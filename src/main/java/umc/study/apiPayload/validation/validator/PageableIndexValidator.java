package umc.study.apiPayload.validation.validator;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import org.springframework.data.domain.Pageable;

public class PageableIndexValidator implements ConstraintValidator<ValidPageableIndex, Pageable> {
    @Override
    public boolean isValid(Pageable pageable, ConstraintValidatorContext context) {
        if (pageable == null) {
            return true;  // null 처리 정책에 따라 변경
        }
        int pageNumber = pageable.getPageNumber(); // 0-based
        // 프론트가 1-based로 보냈다면 getPageNumber()==0 은 page=1,
        // 음수나 0 이하(프론트가 0이거나 음수 보내면) 검증 실패
        return pageNumber >= 0;
    }
}