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
            return true; // @NotNull 등 개별 필드 제약에 맡김
        }

        boolean exists = memberMissionRepository.existsByMemberIdAndMissionId(
                dto.getMemberId(), dto.getMissionId());

        if (exists) {
            context.disableDefaultConstraintViolation();
            context.buildConstraintViolationWithTemplate(
                            "Member "+ dto.getMemberId() +
                                    " is already registered for mission "+ dto.getMissionId()
                    )
                    .addPropertyNode("missionId")   // 또는 전체 DTO 수준: .addBeanNode()
                    .addConstraintViolation();
            return false;
        }

        return true;
    }
}
