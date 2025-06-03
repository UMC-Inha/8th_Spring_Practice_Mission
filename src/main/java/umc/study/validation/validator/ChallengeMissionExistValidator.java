package umc.study.validation.validator;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import umc.study.apiPayload.code.status.ErrorStatus;
import umc.study.domain.enums.MissionStatus;
import umc.study.repository.mission.UserMissionRepository;
import umc.study.validation.annotation.ChallengeMission;
import umc.study.web.dto.request.UserMissionRequestDto;

@Component
@RequiredArgsConstructor
public class ChallengeMissionExistValidator implements ConstraintValidator<ChallengeMission, UserMissionRequestDto.RegisterDto> {
    private final UserMissionRepository userMissionRepository;

    @Override
    public boolean isValid(UserMissionRequestDto.RegisterDto request, ConstraintValidatorContext context) {
        if (request.getUserId() == null || request.getMissionId() == null) return true;

        boolean exists = userMissionRepository.existsByUserIdAndMission_MissionIdAndStatus(
                request.getUserId(), request.getMissionId(), MissionStatus.IN_PROGRESS
        );

        if (exists) {
            context.disableDefaultConstraintViolation();
            context.buildConstraintViolationWithTemplate(ErrorStatus.DUPLICATE_CHALLENGE.getMessage())
                    .addConstraintViolation();
            return false;
        }

        return true;
    }
}
