package umc.converter;

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

	public static Restaurant toRestaurant(RestaurantRequestDto.JoinDto request){
		return Restaurant.builder()
			.name(request.getRestaurantName())
			.score(0.0f)
			.build();
	}
}
