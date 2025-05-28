package umc.dto;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

public class MissionResponseDto {
	@Builder
	@Getter
	@AllArgsConstructor
	public static class JoinResultDto{
		Long missionId;
		LocalDateTime createdAt;
	}

	@Builder
	@Getter
	@AllArgsConstructor
	public static class ChallengeResultDto{
		Long memberMissionId;
		LocalDateTime createdAt;
	}

	@Builder
	@Getter
	@AllArgsConstructor
	public static class MissionListDto {
		List<MissionDto> missionList;
		Integer listSize;
		Integer totalPage;
		Long totalElements;
		Boolean isFirst;
		Boolean isLast;
	}

	@Builder
	@Getter
	@AllArgsConstructor
	public static class MissionDto {
		Long missionId;
		String content;
		Integer point;
		LocalDate deadline;
	}

	@Builder
	@Getter
	@AllArgsConstructor
	public static class UserMissionListDto {
		List<UserMissionDto> missionList;
		Integer listSize;
		Integer totalPage;
		Long totalElements;
		Boolean isFirst;
		Boolean isLast;
	}

	@Builder
	@Getter
	@AllArgsConstructor
	public static class UserMissionDto {
		Long missionId;
		Long restaurantId;
		String content;
		Integer point;
		LocalDate deadline;
	}
}
