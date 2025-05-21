package umc.service.RestaurantService;

import umc.domain.Restaurant;
import umc.dto.RestaurantRequestDto;

public interface RestaurantCommandService {
	Restaurant joinRestaurant(RestaurantRequestDto.JoinDto request);
}
