package umc.dto;

import java.time.LocalDate;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import umc.domain.enums.MissionStatus;
import umc.validation.annotation.ExistChallenge;
import umc.validation.annotation.ExistRestaurant;

public class MissionRequestDto {
	@Getter
	public static class JoinMissionDto {
		@ExistRestaurant
		Long restaurantId;
		@NotBlank
		String content;
		@NotNull
		Integer point;
		@NotNull
		LocalDate deadline;
	}

	@Getter
	@ExistChallenge
	public static class ChallengeDto {
		@NotNull
		Long missionId;
		@NotBlank
		String userEmail;
		@NotNull
		MissionStatus status;
	}
}
