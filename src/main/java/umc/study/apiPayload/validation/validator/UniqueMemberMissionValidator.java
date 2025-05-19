package umc.study.apiPayload.validation.validator;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import umc.study.apiPayload.validation.annotation.UniqueMemberMission;
import umc.study.repository.MemberRepository.MemberMissionRepository;
import umc.study.web.dto.Mission.MemberMissionRequestDto;

@Component
@RequiredArgsConstructor
public class UniqueMemberMissionValidator
        implements ConstraintValidator<UniqueMemberMission, MemberMissionRequestDto.JoinDto> {

    private final MemberMissionRepository memberMissionRepository;

    @Override
    public boolean isValid(MemberMissionRequestDto.JoinDto dto,
                           ConstraintValidatorContext context) {
        if (dto.getMemberId() == null || dto.getMissionId() == null) {
            return true;
        }

        boolean exists = memberMissionRepository.existsByMemberIdAndMissionId(
                dto.getMemberId(), dto.getMissionId());

        if (exists) {
            context.disableDefaultConstraintViolation();
            context.buildConstraintViolationWithTemplate(
                            "Member "+ dto.getMemberId() +
                                    " 가 이미 미션에 도전중입니다. missionId: "+ dto.getMissionId()
                    )
                    .addPropertyNode("missionId")
                    .addConstraintViolation();
            return false;
        }

        return true;
    }
}
