package umc.study.web.dto.request;

import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;
import umc.study.validation.annotation.ChallengeMission;

public class UserMissionRequestDto {


    @Getter
    @Setter
    public static class CompletedDto {
        @NotNull(message = "유저 ID는 필수입니다.")
        private Long userId;

        @NotNull(message = "미션 ID는 필수입니다,")
        private Long missionId;
    }

    @Getter
    @Setter
    @ChallengeMission
    public static class RegisterDto {
        @NotNull(message = "유저 ID는 필수입니다.")
        private Long userId;

        @NotNull(message = "미션 ID는 필수입니다,")
        private Long missionId;
    }
}