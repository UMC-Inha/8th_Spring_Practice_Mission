package umc.dto;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

public class ReviewResponseDto {

	@Builder
	@Getter
	@AllArgsConstructor
	public static class JoinResultDto{
		Long reviewId;
		LocalDateTime createdAt;
	}
}
