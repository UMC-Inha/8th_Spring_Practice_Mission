package umc.study.web.dto.Mission;

import jakarta.validation.constraints.NotBlank;
import lombok.Getter;

public class MemberMissionRequestDto {

    @Getter
    public static class JoinDto{
        @NotBlank
        Long memberId;

        @NotBlank
        Long missionId;
    }
}
