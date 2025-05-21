package umc.dto;

import java.time.LocalDateTime;

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
}
