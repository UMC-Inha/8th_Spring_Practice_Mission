package umc.service.MissionService;

import umc.domain.Mission;
import umc.domain.mapping.UserMission;
import umc.dto.MissionRequestDto;

public interface MissionCommandService {
	Mission joinMission(MissionRequestDto.JoinMissionDto request);
	UserMission challengeMission(MissionRequestDto.ChallengeDto request);
	UserMission completeMission(MissionRequestDto.CompleteRequestDto request);
}
