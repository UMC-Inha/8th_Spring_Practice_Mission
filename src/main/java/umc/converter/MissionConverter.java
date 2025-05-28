package umc.converter;

import java.util.List;

import org.springframework.data.domain.Page;

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

	public static MissionResponseDto.MissionListDto toMissionListDto(Page<Mission> missionList) {

		List<MissionResponseDto.MissionDto> missionDtoList = missionList.stream()
			.map(mission -> toMissionDto(mission))
			.toList();

		return MissionResponseDto.MissionListDto.builder()
			.missionList(missionDtoList)
			.listSize(missionDtoList.size())
			.totalPage(missionList.getTotalPages())
			.totalElements(missionList.getTotalElements())
			.isFirst(missionList.isFirst())
			.isLast(missionList.isLast())
			.build();
	}

	private static MissionResponseDto.MissionDto toMissionDto(Mission mission) {

		return MissionResponseDto.MissionDto.builder()
			.missionId(mission.getId())
			.content(mission.getContent())
			.point(mission.getPoint())
			.deadline(mission.getDeadline())
			.build();
	}

	public static MissionResponseDto.UserMissionListDto toUserMissionListDto(Page<UserMission> userMissionList) {

		List<MissionResponseDto.UserMissionDto> userMissionDtoList = userMissionList.stream()
			.map(userMisson -> toUserMissionDto(userMisson))
			.toList();

		return MissionResponseDto.UserMissionListDto.builder()
			.missionList(userMissionDtoList)
			.listSize(userMissionDtoList.size())
			.totalPage(userMissionList.getTotalPages())
			.totalElements(userMissionList.getTotalElements())
			.isFirst(userMissionList.isFirst())
			.isLast(userMissionList.isLast())
			.build();
	}

	public static MissionResponseDto.UserMissionDto toUserMissionDto(UserMission mission) {

		return MissionResponseDto.UserMissionDto.builder()
			.missionId(mission.getId())
			.restaurantId(mission.getMission().getRestaurant().getId())
			.content(mission.getMission().getContent())
			.point(mission.getMission().getPoint())
			.deadline(mission.getMission().getDeadline())
			.build();
	}
}
