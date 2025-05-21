package umc.service.restaurant;

import jakarta.validation.Valid;
import umc.web.dto.restaurant.RestaurantRequestDTO;

public interface RestaurantCommandService {


    void createRestaurant(RestaurantRequestDTO.createRestaurantDTO request, Long locationId);
}
