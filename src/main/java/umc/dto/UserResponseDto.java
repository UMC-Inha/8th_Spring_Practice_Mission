package umc.dto;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

public class UserResponseDto {

	@Builder
	@Getter
	@NoArgsConstructor
	@AllArgsConstructor
	public static class JoinResultDTO{
		Long userId;
		LocalDateTime createdAt;
	}

	@Builder
	@Getter
	@NoArgsConstructor
	@AllArgsConstructor
	public static class LoginResultDTO {
		Long userId;
		String accessToken;
	}
}
