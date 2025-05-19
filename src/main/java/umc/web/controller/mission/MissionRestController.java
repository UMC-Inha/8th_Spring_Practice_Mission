package umc.web.controller.mission;

import io.swagger.v3.oas.annotations.Operation;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import umc.apiPayload.ApiResponse;
import umc.converter.memberMission.MemberMissionConverter;
import umc.converter.mission.MissionConverter;
import umc.domain.Mission;
import umc.domain.mapping.MemberMission;
import umc.dto.mission.MissionRequestDTO;
import umc.dto.mission.MissionResponseDTO;
import umc.service.memberMission.MemberMissionService;
import umc.service.mission.MissionService;

@RestController
@RequiredArgsConstructor
@RequestMapping("/")
public class MissionRestController {

    private final MissionService missionService;
    private final MemberMissionService memberMissionService;

    @PostMapping("/restaurants/{restaurantId}/missions")
    @Operation(summary = "미션 생성 API")
    public ApiResponse<MissionResponseDTO.CreateMissionResultDto> create(@RequestBody @Valid MissionRequestDTO.CreateMissionDto request, @RequestParam("restaurantId") Long restaurantId) {
        Mission newMission = missionService.createMission(request, restaurantId);
        return ApiResponse.onSuccess(MissionConverter.toCreateMissionResultDto(newMission));
    }

    @PostMapping("/restaurants/{restaurantId}/missions/{missionId}")
    @Operation(summary = "미션 도전 API")
    public ApiResponse<MissionResponseDTO.ChallengeMissionResultDto> challenge(@RequestBody @Valid MissionRequestDTO.ChallengeMissionDto request,
                                                                               @RequestParam("missionId") Long missionId) {
        MemberMission newMemberMission = memberMissionService.challengeMission(request, missionId);
        return ApiResponse.onSuccess(MemberMissionConverter.toChallengeMissionResultDto(newMemberMission));
    }
}
