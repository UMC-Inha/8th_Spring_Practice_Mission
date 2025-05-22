package umc.study.web.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import umc.study.apiPayload.ApiResponse;
import umc.study.converter.MissionConverter;
import umc.study.domain.Mission;
import umc.study.service.MissionService.MissionCommandService;
import umc.study.validation.annotation.ExistStores;
import umc.study.web.dto.request.MissionRequestDTO;
import umc.study.web.dto.response.MissionResponseDTO;

@Validated
@RestController
@RequiredArgsConstructor
public class MissionRestController {
    private final MissionCommandService missionCommandService;

    @PostMapping("/api/v1/stores/{storeId}/missions")
    public ApiResponse<MissionResponseDTO.createResultDTO> addMission(@PathVariable @ExistStores Long storeId, @RequestBody @Valid MissionRequestDTO.createMissionDTO request) {
        Mission mission = missionCommandService.createMission(storeId, request);
        return ApiResponse.onSuccess(MissionConverter.toCreateResultDTO(mission));
    }
}
