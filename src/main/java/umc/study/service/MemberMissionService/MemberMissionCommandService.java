package umc.study.service.MemberMissionService;

import umc.study.domain.mapping.MemberMission;
import umc.study.web.dto.request.MemberMissionRequestDTO;

public interface MemberMissionCommandService {
    public MemberMission createMemberMission(MemberMissionRequestDTO.createChallengeDTO request);
}
