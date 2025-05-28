package umc.study.web.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.Parameters;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import umc.study.apiPayload.ApiResponse;
import umc.study.converter.StoreConverter;
import umc.study.converter.UserConverter;
import umc.study.domain.Mission;
import umc.study.domain.Review;
import umc.study.domain.User;
import umc.study.domain.enums.MissionStatus;
import umc.study.domain.mapping.UserMission;
import umc.study.repository.UserMissionRepository.UserMissionRepository;
import umc.study.service.MissionService.MissionCommandServiceImpl;
import umc.study.service.UserMissionService.UserMissionCommandServiceImpl;
import umc.study.validation.annotation.ExistStore;
import umc.study.validation.annotation.ExistUser;
import umc.study.web.dto.MissionRequestDto;
import umc.study.web.dto.MissionResponseDto;
import umc.study.web.dto.StoreResponseDto;
import umc.study.web.dto.UserResponseDto;

@RestController
@RequiredArgsConstructor
@RequestMapping("/mission")
public class MissionRestController {
    private final MissionCommandServiceImpl missionCommandService;
    private final UserMissionCommandServiceImpl userMissionCommandService;

    public ApiResponse<MissionResponseDto.toResultDto> addMission(@RequestBody @Valid MissionRequestDto request) {
        MissionResponseDto.toResultDto result = missionCommandService.addMission(request);
        return ApiResponse.onSuccess(result);
    }

    @GetMapping("/{storeId}/missions")
    @Operation(summary = "특정 가게의 미션 목록 조회 API",description = "특정 가게의 미션들의 목록을 조회하는 API이며, 페이징을 포함합니다. query String 으로 page 번호를 주세요")
    @Parameters({
            @Parameter(name = "storeId", description = "가게의 아이디, path variable 입니다!")
    })
    public ApiResponse<StoreResponseDto.MissionListDTO> getStoreMissions(
            @ExistStore @PathVariable(name = "storeId") Long storeId,
            @RequestParam(name = "page") Integer page) {

        Page<Mission> missions = missionCommandService.getMissionsByStore(storeId, page);
        return ApiResponse.onSuccess(StoreConverter.toMissionListDTO(missions));
    }

    @GetMapping("/missions/ongoing")
    @Operation(summary = "내가 진행 중인 미션 목록 조회 API", description = "진행 중 상태의 유저-미션 목록을 페이징하여 반환합니다.")
    public ApiResponse<UserResponseDto.OngoingMissionListDTO> getOngoingMissions(
            @RequestParam @ExistUser Long userId,
            @RequestParam(name = "page") Integer page) {

        Page<UserMission> userMissions = userMissionCommandService.getOngoingMissions(userId, page);
        return ApiResponse.onSuccess(UserConverter.toOngoingMissionListDTO(userMissions));
    }
}

