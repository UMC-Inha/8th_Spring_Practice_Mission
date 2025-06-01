package umc.presentation.controller.mission;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.Parameters;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import umc.application.converter.MissionConverter;
import umc.application.service.mission.MissionCommandService;
import umc.application.service.mission.MissionQueryService;
import umc.common.ApiPayload.ApiResponse;
import umc.common.validation.annotation.ExistStore;
import umc.common.validation.annotation.ExistUser;
import umc.common.validation.annotation.ValidEnum;
import umc.infrastructure.persistence.entity.mission.MissionState;
import umc.presentation.dto.ResponseEntityUtil;
import umc.presentation.dto.mission.MissionRequestDto;

@RestController
@RequestMapping("/api/missions")
@RequiredArgsConstructor
public class MissionApiController {
    private final MissionCommandService missionCommandService;
    private final MissionQueryService missionQueryService;

    @PostMapping("/")
    public ResponseEntity<ApiResponse<?>> createMission(@RequestBody @Valid MissionRequestDto.MissionCreateDto request){
        return ResponseEntityUtil.buildResponseEntityWithStatus(ApiResponse.onSuccess(missionCommandService.createMission(request)), HttpStatus.CREATED);

    }

    @PostMapping("/add-mission")
    public ResponseEntity<ApiResponse<?>> addMissionToUser(@RequestBody @Valid MissionRequestDto.AddMissionToUserDto request) {
        return ResponseEntityUtil.buildResponseEntityWithStatus(ApiResponse.onSuccess(missionCommandService.addMissionToUser(request)), HttpStatus.CREATED);
    }

    @Operation(summary = "특정 가게의 미션 목록 조회 API",description = "특정 가게의 미션들의 목록을 조회하는 API이며, 페이징을 포함합니다. query String 으로 page 번호를 주세요")
    @ApiResponses({
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "COMMON200",description = "OK, 성공"),
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "AUTH003", description = "access 토큰을 주세요!",content = @Content(schema = @Schema(implementation = ApiResponse.class))),
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "AUTH004", description = "acess 토큰 만료",content = @Content(schema = @Schema(implementation = ApiResponse.class))),
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "AUTH006", description = "acess 토큰 모양이 이상함",content = @Content(schema = @Schema(implementation = ApiResponse.class))),
    })
    @Parameters({
            @Parameter(name = "storeId", description = "가게의 아이디, path variable 입니다!")
    })
    @GetMapping("/{storeId}/missions")
    public ResponseEntity<ApiResponse<?>> getMissionsByStoreId(@ExistStore @PathVariable(name = "storeId") Long storeId, @RequestParam(name = "page") Integer page) {
        return ResponseEntityUtil.buildDefaultResponseEntity(ApiResponse.onSuccess(
                MissionConverter.toMissionPreviewListDto( missionQueryService.getMissionsByStoreId(storeId, page))
        ));
    }

    @Operation(summary = "특정 유저의 미션 목록 조회 API",description = "특정 유저의 미션들의 목록을 조회하는 API이며, 페이징을 포함합니다. query String 으로 page 번호를 주세요")
    @ApiResponses({
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "COMMON200",description = "OK, 성공"),
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "AUTH003", description = "access 토큰을 주세요!",content = @Content(schema = @Schema(implementation = ApiResponse.class))),
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "AUTH004", description = "acess 토큰 만료",content = @Content(schema = @Schema(implementation = ApiResponse.class))),
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "AUTH006", description = "acess 토큰 모양이 이상함",content = @Content(schema = @Schema(implementation = ApiResponse.class))),
    })
    @Parameters({
            @Parameter(name = "userId", description = "유저의 아이디, 로그인 구현 이후에는 해당 내용을 제거하고 JWT Token, 혹은 ContextHolder를 통해 유저 정보를 가져올 예정입니다.")
    })
    @GetMapping("/{userId}/missions/{missionState}") //원래라면 context holder의 유저정보, 혹은 jwt token의 유저정보를 가져올 것 . .
    public ResponseEntity<ApiResponse<?>> getMissionByUserId(@ExistUser @PathVariable(name = "userId") Long userId,
                                                             @PathVariable(name="missionState") @ValidEnum(enumClass = MissionState.class) String state,
                                                             @RequestParam(name = "page") Integer page) {
        return ResponseEntityUtil.buildDefaultResponseEntity(ApiResponse.onSuccess(
                MissionConverter.toMissionPreviewListDto(missionQueryService.getMissionsByUserId(userId, MissionState.valueOf(state), page))
        ));
    }

    @PatchMapping("/complete")
    public ResponseEntity<ApiResponse<?>> completeMission(@RequestBody MissionRequestDto.MissionStateChangeDto request){
        return ResponseEntityUtil.buildDefaultResponseEntity(
                ApiResponse.onSuccess(missionCommandService.changeMissionState(request))
        );
    }
}
