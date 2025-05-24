package umc.study.web.controller;

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
    public ApiResponse<MissionResponseDto.RegisterResultDto> registerMission(
            @RequestBody @Valid MissionRequestDto.RegisterDto request) {
        return ApiResponse.onSuccess(
                MissionConverter.toMissionRegisterResultDto(missionCommandService.registerMission(request))
        );
    }
}
