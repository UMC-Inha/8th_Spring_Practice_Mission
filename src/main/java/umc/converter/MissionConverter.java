package umc.converter;

import umc.domain.Mission;
import umc.domain.mapping.UserMission;
import umc.dto.MissionRequestDto;
import umc.dto.MissionResponseDto;

public class MissionConverter {

	public static MissionResponseDto.JoinResultDto toJoinResultDTO(Mission mission){
		return MissionResponseDto.JoinResultDto.builder()
			.missionId(mission.getId())
			.createdAt(mission.getCreatedAt())
			.build();
	}

	public static MissionResponseDto.ChallengeResultDto toChallengeResultDto(UserMission userMission) {
		return MissionResponseDto.ChallengeResultDto.builder()
			.memberMissionId(userMission.getId())
			.createdAt(userMission.getCreatedAt())
			.build();
	}

	public static Mission toMission(MissionRequestDto.JoinMissionDto request){
		return Mission.builder()
			.content(request.getContent())
			.point(request.getPoint())
			.deadline(request.getDeadline())
			.build();
	}

	public static UserMission toUserMission(MissionRequestDto.ChallengeDto request) {
		return UserMission.builder()
			.status(request.getStatus())
			.build();
	}

}
