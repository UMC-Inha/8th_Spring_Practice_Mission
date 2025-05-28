package umc.web.controller.restaurant;

import io.swagger.v3.oas.annotations.Operation;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import umc.apiPayload.ApiResponse;
import umc.converter.restaurant.RestaurantConverter;
import umc.domain.Restaurant;
import umc.dto.restaurant.RestaurantRequestDTO;
import umc.dto.restaurant.RestaurantResponseDTO;
import umc.service.restaurant.RestaurantService;

@RestController
@RequiredArgsConstructor
@RequestMapping("/restaurants")
public class RestaurantRestController {

    private final RestaurantService restaurantService;

    @PostMapping("/")
    @Operation(summary = "가게 생성 API")
    public ApiResponse<RestaurantResponseDTO.CreateRestaurantResultDto> create(@RequestBody @Valid RestaurantRequestDTO.CreateRestaurantDto request) {
        Restaurant newRestaurant = restaurantService.create(request);
        return ApiResponse.onSuccess(RestaurantConverter.toCreateRestaurantResultDto(newRestaurant));
    }
}
