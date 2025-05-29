package umc.UMC8th.service;

import umc.UMC8th.domain.mapping.MemberMission;
import umc.UMC8th.dto.MissionChallengeRequest;


public interface MemberMissionCommandService {
    void completeMission(Long memberMissionId);
    MemberMission challengeMission(MissionChallengeRequest request);
}