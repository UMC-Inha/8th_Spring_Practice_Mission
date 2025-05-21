package umc.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import umc.validation.annotation.ExistCategory;
import umc.validation.annotation.ExistRegion;

public class RestaurantRequestDto {

	@Getter
	public static class JoinDto {
		@NotBlank
		String restaurantName;
		@ExistRegion
		String regionName;
		@ExistCategory
		Long foodCategory;
	}
}
