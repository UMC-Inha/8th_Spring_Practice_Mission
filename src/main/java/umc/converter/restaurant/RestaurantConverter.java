package umc.converter.restaurant;

import umc.domain.FoodCategory;
import umc.domain.Location;
import umc.domain.Restaurant;
import umc.dto.restaurant.RestaurantRequestDTO;
import umc.dto.restaurant.RestaurantResponseDTO;

import java.time.LocalDateTime;

public class RestaurantConverter {

    public static RestaurantResponseDTO.CreateRestaurantResultDto toCreateRestaurantResultDto(Restaurant restaurant) {
        return RestaurantResponseDTO.CreateRestaurantResultDto.builder()
                .restaurantId(restaurant.getId())
                .createdAt(LocalDateTime.now())
                .build();
    }

    public static Restaurant toRestaurant (RestaurantRequestDTO.CreateRestaurantDto request, Location location, FoodCategory foodCategory) {
        return Restaurant.builder()
                .name(request.getName())
                .address(request.getAddress())
                .mapLocation(request.getMapLocation())
                .scoreAvg(0.0)
                .location(location)
                .foodCategory(foodCategory)
                .build();
    }
}
