package umc.study.web.controller;

import io.swagger.v3.oas.annotations.Operation;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import umc.study.apiPayload.ApiResponse;
import umc.study.converter.UserMissionConverter;
import umc.study.service.mission.UserMissionCommandService;
import umc.study.validation.annotation.ValidatedPage;
import umc.study.web.dto.request.UserMissionRequestDto;
import umc.study.web.dto.response.UserMissionResponseDto;

@RestController
@RequiredArgsConstructor
@RequestMapping("/userMissions")
public class UserMissionRestController {

    private final UserMissionCommandService userMissionCommandService;

    @GetMapping("/{userId}/in_progress")
    @Operation(summary = "사용자 도전중 미션 목록 조회 API", description = "사용자가 도전중인 미션들을 조회하는 API 입니다. 페이징이 포함되어 있어 Page, size를 주세요.")
    public ApiResponse<UserMissionResponseDto.UserMissionListDto> getInProgressMission(
            @PathVariable Long userId,
            @ValidatedPage @RequestParam(defaultValue = "0") Integer page,
            @RequestParam(defaultValue = "10") Integer size
    ) {
        return ApiResponse.onSuccess(
                UserMissionConverter.toUserMissionListDto(userMissionCommandService.findInProgressMissions(userId, page, size))
        );
    }

    @PostMapping("/challenge")
    @Operation(summary = "사용자 미션 도전 API", description = "사용자가 특정 미션에 도전하는 API 입니다.")
    public ApiResponse<UserMissionResponseDto.RegisterResultDto> postChallengeMission(
            @RequestBody @Valid UserMissionRequestDto.RegisterDto request) {

        return ApiResponse.onSuccess(
                UserMissionConverter.toUserMissionRegisterResultDto(userMissionCommandService.challengeMission(request))
        );
    }

    @PostMapping("/completed")
    @Operation(summary = "사용자 미션 완료 API", description = "사용자가 특정 미션을 완료하는 API 입니다.")
    public ApiResponse<UserMissionResponseDto.CompletedResultDto> postCompletedMission(
            @RequestBody @Valid UserMissionRequestDto.CompletedDto request) {
        return ApiResponse.onSuccess(
                UserMissionConverter.toUserMissionCompletedResultDto(userMissionCommandService.completeMission(request))
        );
    }
}