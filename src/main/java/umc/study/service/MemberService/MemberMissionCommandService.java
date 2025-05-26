package umc.study.service.MemberService;

import jakarta.validation.Valid;
import umc.study.domain.mapping.MemberMission;
import umc.study.web.dto.Mission.MemberMissionRequestDto;

public interface MemberMissionCommandService {
    MemberMission joinMemberMission(MemberMissionRequestDto.@Valid JoinDto request);
}
