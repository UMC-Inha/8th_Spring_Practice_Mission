package umc.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import umc.apiPayload.ApiResponse;
import umc.converter.RestaurantConverter;
import umc.domain.Restaurant;
import umc.dto.RestaurantRequestDto;
import umc.dto.RestaurantResponseDto;
import umc.service.RestaurantService.RestaurantCommandService;

@RestController
@RequiredArgsConstructor
@RequestMapping("/restaurants")
public class RestaurantController {

	private final RestaurantCommandService restaurantCommandService;

	@PostMapping
	public ResponseEntity<ApiResponse<RestaurantResponseDto.JoinResultDto>> join(@RequestBody @Valid RestaurantRequestDto.JoinDto request){
		Restaurant restaurant = restaurantCommandService.joinRestaurant(request);
		return ResponseEntity.ok(ApiResponse.onSuccess(RestaurantConverter.toJoinResultDto(restaurant)));
	}
}
