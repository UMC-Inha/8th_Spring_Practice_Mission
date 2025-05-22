package umc.study.web.dto;

import lombok.Getter;
import umc.study.validation.annotation.AlreadyMissionChallenge;
import umc.study.validation.annotation.ExistMember;
import umc.study.validation.annotation.ExistMission;

public class MemberMissionRequestDTO {
    @Getter
    @AlreadyMissionChallenge
    public static class createChallengeDTO {
        @ExistMember
        Long memberId;
        @ExistMission
        Long missionId;
    }
}
