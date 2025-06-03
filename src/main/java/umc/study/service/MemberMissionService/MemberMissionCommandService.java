package umc.study.service.MemberMissionService;

import umc.study.web.dto.MissionChallengeDTO.MissionChallengeRequestDTO;
import umc.study.web.dto.MissionChallengeDTO.MissionChallengeResponseDTO;

public interface MemberMissionCommandService {
    MissionChallengeResponseDTO.MissionChallengeJoinResultDTO challengeMission(MissionChallengeRequestDTO.MissionChallengeJoinDTO request);
    void completeMission(Long memberMissionId);
}
