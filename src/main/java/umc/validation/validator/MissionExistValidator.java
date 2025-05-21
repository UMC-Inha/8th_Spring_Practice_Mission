package umc.validation.validator;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import umc.apiPayload.code.status.ErrorStatus;
import umc.apiPayload.exception.GeneralException;
import umc.domain.Mission;
import umc.domain.User;
import umc.domain.mapping.UserMission;
import umc.repository.mission.MissionRepository;
import umc.repository.user.UserMissionRepository;
import umc.repository.user.UserRepository;
import umc.validation.annotation.ExistMission;
import umc.validation.annotation.ExistUser;

@Component
@RequiredArgsConstructor
public class MissionExistValidator implements ConstraintValidator<ExistMission, Long> {

    private final MissionRepository missionRepository;
    private final UserMissionRepository userMissionRepository;
    private final UserRepository userRepository;

    @Override
    public void initialize(ExistMission constraintAnnotation) {
        ConstraintValidator.super.initialize(constraintAnnotation);
    }

    @Override
    public boolean isValid(Long aLong, ConstraintValidatorContext context) {

        boolean isValid = false;
        Mission mission = missionRepository.findById(aLong).orElse(null);

        // 미션이 존재하지 않을 때
        if (mission == null) {
            context.disableDefaultConstraintViolation();
            context.buildConstraintViolationWithTemplate(ErrorStatus.MISSION_NOT_FOUND.toString()).addConstraintViolation();
            return isValid;
        }

        User user = userRepository.findById(1L).orElseThrow(
                () -> new GeneralException(ErrorStatus.USER_NOT_FOUND)
        );
        Boolean existsUserMissionByUserAndMission = userMissionRepository.existsUserMissionByUserAndMission(user, mission);

        // 이미 수행 중인 미션일 때
        if(existsUserMissionByUserAndMission){
            context.disableDefaultConstraintViolation();
            context.buildConstraintViolationWithTemplate(ErrorStatus.MISSION_ALREADY_EXIST.toString()).addConstraintViolation();
            return isValid;
        }

        isValid = true;
        return isValid;
    }
}