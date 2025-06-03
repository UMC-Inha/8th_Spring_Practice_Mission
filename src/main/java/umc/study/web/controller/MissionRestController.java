package umc.study.web.controller;

import io.swagger.v3.oas.annotations.Operation;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import umc.study.apiPayload.ApiResponse;
import umc.study.converter.MissionConverter;
import umc.study.service.mission.MissionCommandService;
import umc.study.web.dto.request.MissionRequestDto;
import umc.study.web.dto.response.MissionResponseDto;

@RestController
@RequiredArgsConstructor
@RequestMapping("/missions")
public class MissionRestController {

    private final MissionCommandService missionCommandService;

    @PostMapping("/")
    @Operation(summary = "특정 미션 등록 API", description = "특정 가게에 미션을 등록하는 API 입니다.")
    public ApiResponse<MissionResponseDto.RegisterResultDto> postRegisterMission(
            @RequestBody @Valid MissionRequestDto.RegisterDto request) {
        return ApiResponse.onSuccess(
                MissionConverter.toMissionRegisterResultDto(missionCommandService.registerMission(request))
        );
    }
}
