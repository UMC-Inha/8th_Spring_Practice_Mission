package umc.study.service.MemberMissionService;

import umc.study.domain.mapping.MemberMission;
import umc.study.web.dto.MemberMissionRequestDTO;

public interface MemberMissionCommandService {
    public MemberMission createMemberMission(MemberMissionRequestDTO.createChallengeDTO request);
}
