package umc.web.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.Parameters;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import umc.apiPayload.ApiResponse;
import umc.converter.MissionConverter;
import umc.domain.Mission;
import umc.domain.Review;
import umc.domain.mapping.UserMission;
import umc.service.mission.MissionCommandService;
import umc.service.mission.MissionQueryService;
import umc.service.restaurant.RestaurantCommandService;
import umc.validation.annotation.*;
import umc.web.dto.mission.MissionRequestDTO;
import umc.web.dto.mission.MissionResponseDTO;
import umc.web.dto.restaurant.RestaurantRequestDTO;

@RestController
@RequiredArgsConstructor
@Validated
public class MissionRestController {

    private final MissionCommandService missionCommandService;
    private final MissionQueryService missionQueryService;

    @PostMapping("/restaurants/{restaurantId}/missions")
    public ApiResponse<String> createMission(
            @RequestBody @Valid MissionRequestDTO.createMissionDTO request, @ExistRestaurant @PathVariable Long restaurantId) {

        missionCommandService.createMission(request, restaurantId);
        return ApiResponse.onSuccess("미션이 등록되었습니다");

    }

    @GetMapping("/restaurants/{restaurantId}/missions")
    @Operation(summary = "특정 가게의 미션 목록 조회 API",description = "특정 가게의 미션들의 목록을 조회하는 API이며, 페이징을 포함합니다. query String 으로 page 번호를 주세요")
    @ApiResponses({
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "COMMON200",description = "OK, 성공"),
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "AUTH003", description = "access 토큰을 주세요!",content = @Content(schema = @Schema(implementation = ApiResponse.class))),
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "AUTH004", description = "acess 토큰 만료",content = @Content(schema = @Schema(implementation = ApiResponse.class))),
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "AUTH006", description = "acess 토큰 모양이 이상함",content = @Content(schema = @Schema(implementation = ApiResponse.class))),
    })
    @Parameters({
            @Parameter(name = "restaurantId", description = "가게의 아이디, path variable 입니다!")
    })
    public ApiResponse<MissionResponseDTO.MissionListDTO> getMissionListByRestaurantId(
            @ExistRestaurant @PathVariable(name = "restaurantId") Long restaurantId,
            @CheckPage @RequestParam(name = "page") Integer page) {

        Page<Mission> missionListByRestaurantId = missionQueryService.getMissionListByRestaurantId(restaurantId, page);
        return ApiResponse.onSuccess(MissionConverter.toMissionListDTO(missionListByRestaurantId));
    }


    @GetMapping("/missions")
    @Operation(summary = "내가 진행 중인 미션 목록 조회 API",description = "내가 진행 중인 미션들의 목록을 조회하는 API이며, 페이징을 포함합니다. query String 으로 page 번호를 주세요")
    @ApiResponses({
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "COMMON200",description = "OK, 성공"),
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "AUTH003", description = "access 토큰을 주세요!",content = @Content(schema = @Schema(implementation = ApiResponse.class))),
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "AUTH004", description = "acess 토큰 만료",content = @Content(schema = @Schema(implementation = ApiResponse.class))),
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "AUTH006", description = "acess 토큰 모양이 이상함",content = @Content(schema = @Schema(implementation = ApiResponse.class))),
    })
    public ApiResponse<MissionResponseDTO.MissionListDTO> getMyMissionList(
            @CheckPage @RequestParam(name = "page") Integer page) {

        Long userId = 1L; // TODO. SecurityUtils 구현 후 토큰에서 userID 가져오기

        Page<UserMission> userMissionList = missionQueryService.getMissionListByUserId(userId, page);
        return ApiResponse.onSuccess(MissionConverter.toUserMissionListDTO(userMissionList));
    }


    @PatchMapping("/users/{userId}/missions/{missionId}")
    @Operation(summary = "진행 중인 미션 진행 완료로 바꾸기 API",description = "해당 mission의 상태를 진행 완료로 변경하는 API이다.")
    @ApiResponses({
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "COMMON200",description = "OK, 성공"),
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "AUTH003", description = "access 토큰을 주세요!",content = @Content(schema = @Schema(implementation = ApiResponse.class))),
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "AUTH004", description = "acess 토큰 만료",content = @Content(schema = @Schema(implementation = ApiResponse.class))),
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "AUTH006", description = "acess 토큰 모양이 이상함",content = @Content(schema = @Schema(implementation = ApiResponse.class))),
    })
    public ApiResponse<String> changeMissionStatus(
            @ExistUser @PathVariable(name = "userId") Long userId,
            @ExistMission @PathVariable(name = "missionId") Long missionId) {

        missionCommandService.changeMissionStatus(userId, missionId);
        return ApiResponse.onSuccess("미션의 상태가 변경되었습니다.");
    }

}
