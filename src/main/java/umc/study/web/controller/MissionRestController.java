package umc.study.web.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import umc.study.apiPayload.ApiResponse;
import umc.study.service.MissionService.MissionCommandServiceImpl;
import umc.study.web.dto.MissionRequestDto;
import umc.study.web.dto.MissionResponseDto;

@RestController
@RequiredArgsConstructor
@RequestMapping("/mission")
public class MissionRestController {
    private final MissionCommandServiceImpl missionCommandServiceImpl;

    @PostMapping
    public ApiResponse<MissionResponseDto.toResultDto> addMission(@RequestBody @Valid MissionRequestDto request) {
        MissionResponseDto.toResultDto result = missionCommandServiceImpl.addMission(request);
        return ApiResponse.onSuccess(result);
    }
}

