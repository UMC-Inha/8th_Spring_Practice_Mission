package umc.study.web.dto.Mission;

import lombok.Getter;
import umc.study.apiPayload.validation.annotation.ExistMember;
import umc.study.apiPayload.validation.annotation.ExistMission;
import umc.study.apiPayload.validation.annotation.UniqueMemberMission;

@UniqueMemberMission
public class MemberMissionRequestDto {

    @Getter
    public static class JoinDto{
        @ExistMember
        Long memberId;

        @ExistMission
        Long missionId;
    }
}
