package umc.validation.validator;

import org.springframework.stereotype.Component;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import lombok.RequiredArgsConstructor;
import umc.apiPayload.code.status.ErrorStatus;
import umc.repository.RegionRepository.RegionRepository;
import umc.validation.annotation.ExistRegion;

@Component
@RequiredArgsConstructor
public class RegionExistValidator implements ConstraintValidator<ExistRegion, String> {

    private final RegionRepository regionRepository;

    @Override
    public boolean isValid(String regionName, ConstraintValidatorContext context) {
        boolean isValid = regionRepository.existsByName(regionName);

        if (!isValid) {
            context.disableDefaultConstraintViolation();
            context.buildConstraintViolationWithTemplate(ErrorStatus.REGION_NOT_FOUND.toString()).addConstraintViolation();
        }

        return isValid;
    }
}
