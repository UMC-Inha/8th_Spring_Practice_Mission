package umc.dto;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import umc.validation.annotation.ExistRestaurant;
import umc.validation.annotation.ExistUser;

public class ReviewRequestDto {

	@Getter
	public static class JoinDto {
		@ExistRestaurant
		Long restaurantId;
		@ExistUser
		String userEmail;
		@NotBlank
		String content;
		@NotNull
		@Min(0)
		@Max(5)
		Integer score;
	}
}
