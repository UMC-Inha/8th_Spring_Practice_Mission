package umc.validation.validator;

import org.springframework.stereotype.Component;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import lombok.RequiredArgsConstructor;
import umc.apiPayload.code.status.ErrorStatus;
import umc.apiPayload.exception.GeneralException;
import umc.domain.User;
import umc.dto.MissionRequestDto;
import umc.repository.UserMissionRepository.UserMissionRepository;
import umc.repository.UserRepository.UserRepository;
import umc.validation.annotation.ExistChallenge;

@Component
@RequiredArgsConstructor
public class ChallengeExistValidator implements ConstraintValidator<ExistChallenge, MissionRequestDto.ChallengeDto> {

    private final UserRepository userRepository;
    private final UserMissionRepository userMissionRepository;

    @Override
    public boolean isValid(MissionRequestDto.ChallengeDto dto, ConstraintValidatorContext context) {
        User user = userRepository.findByEmail(dto.getUserEmail())
                .orElseThrow(() -> new GeneralException(ErrorStatus.USER_NOT_FOUND));

        boolean isValid = !userMissionRepository.existsByUserIdAndMissionId(user.getId(), dto.getMissionId());

        if (!isValid) {
            context.disableDefaultConstraintViolation();
            context.buildConstraintViolationWithTemplate(ErrorStatus.ALREADY_CHALLENGE.toString()).addConstraintViolation();
        }

        return isValid;
    }
}
