package umc.web.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import umc.apiPayload.ApiResponse;
import umc.converter.UserConverter;
import umc.domain.User;
import umc.service.restaurant.RestaurantCommandService;
import umc.service.restaurant.RestaurantCommandServiceImpl;
import umc.validation.annotation.ExistLocation;
import umc.web.dto.restaurant.RestaurantRequestDTO;
import umc.web.dto.user.UserRequestDTO;
import umc.web.dto.user.UserResponseDTO;

@RestController
@RequiredArgsConstructor
@RequestMapping("/restaurants")
@Validated
public class RestaurantRestController {

    private final RestaurantCommandService restaurantCommandService;

    @PostMapping("/location/{locationId}")
    public ApiResponse<String> createRestaurant(
            @RequestBody @Valid RestaurantRequestDTO.createRestaurantDto request, @ExistLocation @PathVariable Long locationId) {

        restaurantCommandService.createRestaurant(request, locationId);
        return ApiResponse.onSuccess("식당이 등록되었습니다");

    }





}
