package umc.converter;

import umc.domain.Category;
import umc.domain.Region;
import umc.domain.Restaurant;
import umc.dto.RestaurantRequestDto;
import umc.dto.RestaurantResponseDto;

public class RestaurantConverter {

	public static RestaurantResponseDto.JoinResultDto toJoinResultDto(Restaurant restaurant){
		return RestaurantResponseDto.JoinResultDto.builder()
			.restaurantId(restaurant.getId())
			.createdAt(restaurant.getCreatedAt())
			.build();
	}

	public static Restaurant toRestaurant(RestaurantRequestDto.JoinDto request, Region region, Category category){
		return Restaurant.builder()
			.name(request.getRestaurantName())
			.score(0.0f)
			.region(region)
			.category(category)
			.build();
	}
}
