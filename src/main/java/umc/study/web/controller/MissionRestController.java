package umc.study.web.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import umc.study.apiPayload.ApiResponse;
import umc.study.converter.MissionConverter;
import umc.study.domain.Mission;
import umc.study.service.MissionService.MissionCommandService;
import umc.study.web.dto.Mission.MissionRequestDto;
import umc.study.web.dto.Mission.MissionResponseDto;

@RestController
@RequiredArgsConstructor
@Validated
@RequestMapping("/missions")
public class MissionRestController {

    private final MissionCommandService missionCommandService;

    @PostMapping("")
    public ApiResponse<MissionResponseDto.JoinResultDTO> join(@RequestBody @Valid MissionRequestDto.JoinDto request){
        Mission mission = missionCommandService.registerMission(request);
        return ApiResponse.onSuccess(MissionConverter.toJoinResultDTO(mission));
    }
}
