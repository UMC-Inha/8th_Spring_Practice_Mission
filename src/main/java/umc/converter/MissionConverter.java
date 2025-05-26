package umc.converter;

import umc.domain.Mission;
import umc.domain.Restaurant;
import umc.domain.User;
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

	public static Mission toMission(MissionRequestDto.JoinMissionDto request, Restaurant restaurant) {
		return Mission.builder()
			.content(request.getContent())
			.point(request.getPoint())
			.deadline(request.getDeadline())
			.restaurant(restaurant)
			.region(restaurant.getRegion())
			.build();
	}

	public static UserMission toUserMission(MissionRequestDto.ChallengeDto request, User user, Mission mission) {
		return UserMission.builder()
			.status(request.getStatus())
			.user(user)
			.mission(mission)
			.build();
	}

}
