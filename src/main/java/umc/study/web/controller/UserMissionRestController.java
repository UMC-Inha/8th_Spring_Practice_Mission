package umc.study.web.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import umc.study.apiPayload.ApiResponse;
import umc.study.converter.UserMissionConverter;
import umc.study.service.mission.UserMissionCommandService;
import umc.study.web.dto.request.UserMissionRequestDto;
import umc.study.web.dto.response.UserMissionResponseDto;

@RestController
@RequiredArgsConstructor
@RequestMapping("/userMissions")
public class UserMissionRestController {

    private final UserMissionCommandService userMissionCommandService;

    @PostMapping("/challenge")
    public ApiResponse<UserMissionResponseDto.RegisterResultDto> challengeMission(
            @RequestBody @Valid UserMissionRequestDto.RegisterDto request) {

        return ApiResponse.onSuccess(
                UserMissionConverter.toUserMissionRegisterResultDto(userMissionCommandService.challengeMission(request))
        );
    }
}