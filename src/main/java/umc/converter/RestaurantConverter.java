package umc.converter;

import umc.domain.Location;
import umc.domain.Restaurant;
import umc.domain.User;
import umc.domain.enums.Status;
import umc.web.dto.restaurant.RestaurantRequestDTO;
import umc.web.dto.user.UserRequestDTO;

import java.util.ArrayList;

public class RestaurantConverter {

    public static Restaurant toRestaurant(RestaurantRequestDTO.createRestaurantDto request, Location location) {

        return Restaurant.builder()
                .name(request.getName())
                .description(request.getDescription())
                .location(location)
                .total_star(0L)
                .review_count(0L)
                .build();
    }


}
