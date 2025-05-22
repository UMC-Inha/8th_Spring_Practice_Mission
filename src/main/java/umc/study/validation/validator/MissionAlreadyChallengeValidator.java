package umc.study.validation.validator;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import umc.study.apiPayload.code.status.ErrorStatus;
import umc.study.domain.enums.MissionStatus;
import umc.study.repository.MemberMissionRepository;
import umc.study.validation.annotation.AlreadyMissionChallenge;
import umc.study.web.dto.request.MemberMissionRequestDTO;

@Component
@RequiredArgsConstructor
public class MissionAlreadyChallengeValidator implements ConstraintValidator<AlreadyMissionChallenge, MemberMissionRequestDTO.createChallengeDTO> {
    private final MemberMissionRepository memberMissionRepository;

    @Override
    public void initialize(AlreadyMissionChallenge constraintAnnotation) {
        ConstraintValidator.super.initialize(constraintAnnotation);
    }

    @Override
    public boolean isValid(MemberMissionRequestDTO.createChallengeDTO dto, ConstraintValidatorContext context) {
        boolean alreadyExists = memberMissionRepository.existsByMemberIdAndMissionIdAndStatus(
                dto.getMemberId(), dto.getMissionId(), MissionStatus.CHALLENGING
        );

        if (alreadyExists) {
            context.disableDefaultConstraintViolation();
            context.buildConstraintViolationWithTemplate(ErrorStatus.ALREADY_MISSION_CHALLENGE.toString())
                    .addPropertyNode("memberMissionId")
                    .addConstraintViolation();
        }

        return !alreadyExists;
    }
}
