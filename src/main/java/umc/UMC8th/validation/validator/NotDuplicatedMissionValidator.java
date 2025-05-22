package umc.UMC8th.validation.validator;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import umc.UMC8th.service.MissionValidationService;
import umc.UMC8th.validation.annotation.NotDuplicatedMission;

@Component
@RequiredArgsConstructor
public class NotDuplicatedMissionValidator implements ConstraintValidator<NotDuplicatedMission, Long> {

    private final MissionValidationService missionValidationService;

    @Override
    public boolean isValid(Long missionId, ConstraintValidatorContext context) {
        Long hardcodedMemberId = 1L;

        if (missionValidationService.isAlreadyChallenging(hardcodedMemberId, missionId)) {
            context.disableDefaultConstraintViolation();
            context.buildConstraintViolationWithTemplate("이미 도전 중인 미션입니다.")
                    .addConstraintViolation();
            return false;
        }

        return true;
    }
}