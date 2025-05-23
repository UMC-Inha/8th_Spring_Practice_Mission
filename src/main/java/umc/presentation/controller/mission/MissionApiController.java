package umc.presentation.controller.mission;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import umc.application.service.mission.MissionCommandService;
import umc.common.ApiPayload.ApiResponse;
import umc.presentation.dto.ResponseEntityUtil;
import umc.presentation.dto.mission.MissionRequestDto;

@RestController
@RequestMapping("/api/missions")
@RequiredArgsConstructor
public class MissionApiController {
    private final MissionCommandService missionCommandService;
    @PostMapping("/")
    public ResponseEntity<ApiResponse<?>> createMission(@RequestBody MissionRequestDto.MissionCreateDto request){
        return ResponseEntityUtil.buildResponseEntityWithStatus(ApiResponse.onSuccess(missionCommandService.createMission(request)), HttpStatus.CREATED);

    }

    @PostMapping("/add-mission")
    public ResponseEntity<ApiResponse<?>> addMissionToUser(@RequestBody MissionRequestDto.AddMissionToUserDto request) {
        return ResponseEntityUtil.buildResponseEntityWithStatus(ApiResponse.onSuccess(missionCommandService.addMissionToUser(request)), HttpStatus.CREATED);
    }
}
