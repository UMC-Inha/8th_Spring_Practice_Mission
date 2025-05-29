package umc.presentation.controller.mission;

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

    @GetMapping("/{storeId}/missions")
    public ResponseEntity<ApiResponse<?>> getMissionsByStoreId(@ExistStore @PathVariable(name = "storeId") Long storeId, @RequestParam(name = "page") Integer page) {
        return ResponseEntityUtil.buildDefaultResponseEntity(ApiResponse.onSuccess(
                MissionConverter.toMissionPreviewListDto( missionQueryService.getMissionsByStoreId(storeId, page))
        ));
    }



}
