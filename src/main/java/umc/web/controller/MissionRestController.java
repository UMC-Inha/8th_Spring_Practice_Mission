package umc.web.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import umc.apiPayload.ApiResponse;
import umc.service.mission.MissionCommandService;
import umc.service.restaurant.RestaurantCommandService;
import umc.validation.annotation.ExistLocation;
import umc.validation.annotation.ExistRestaurant;
import umc.web.dto.mission.MissionRequestDTO;
import umc.web.dto.restaurant.RestaurantRequestDTO;

@RestController
@RequiredArgsConstructor
@Validated
public class MissionRestController {

    private final MissionCommandService missionCommandService;

    @PostMapping("/restaurants/{restaurantId}/missions")
    public ApiResponse<String> createMission(
            @RequestBody @Valid MissionRequestDTO.createMissionDTO request, @ExistRestaurant @PathVariable Long restaurantId) {

        missionCommandService.createMission(request, restaurantId);
        return ApiResponse.onSuccess("미션이 등록되었습니다");

    }




}
