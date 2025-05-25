package umc.study.validation.validator;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import umc.study.service.MemberMissionService.MemberMissionQueryService;
import umc.study.validation.annotation.NotAlreadyChallenged;
import umc.study.web.dto.MissionChallengeDTO.MissionChallengeRequestDTO;

@Component
@RequiredArgsConstructor
public class NotAlreadyChallengedValidator implements ConstraintValidator<NotAlreadyChallenged, MissionChallengeRequestDTO.MissionChallengeJoinDTO> {
    private final MemberMissionQueryService memberMissionQueryService;

    @Override
    public boolean isValid(MissionChallengeRequestDTO.MissionChallengeJoinDTO request, ConstraintValidatorContext context) {
        if (request.getMemberId() == null || request.getMissionId() == null) {
            return true;
        }

        boolean exists = memberMissionQueryService.isAlreadyChallenged(request.getMemberId(), request.getMissionId());

        if(exists) {
            context.disableDefaultConstraintViolation();
            context.buildConstraintViolationWithTemplate("이미 도전 중인 미션입니다.")
                    .addPropertyNode("memberMissionId")
                    .addConstraintViolation();
            return false;
        }
        return true;
    }
}