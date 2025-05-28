package umc.spring.web.controller;


import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import umc.spring.apiPayload.ApiResponse;
import umc.spring.converter.MemberMissionConverter;
import umc.spring.converter.MissionConverter;
import umc.spring.domain.Mission;
import umc.spring.domain.mapping.MemberMission;
import umc.spring.service.memberMissionService.MemberMissionService;
import umc.spring.service.missionService.MissionService;
import umc.spring.web.dto.mission.MissionRequestDTO;
import umc.spring.web.dto.mission.MissionResponseDTO;

@RestController
@RequiredArgsConstructor
@RequestMapping("/")
public class MissionRestController {

    private final MissionService missionService;
    private final MemberMissionService memberMissionService;

    @PostMapping("/stores/{storesId}/missions")
    public ApiResponse<MissionResponseDTO.CreateMissionResultDto> create(@RequestBody @Valid MissionRequestDTO.CreateMissionDTO request, @RequestParam("storeId") Long storeId){
        Mission newMission = missionService.CreateMission(request, storeId);
        return ApiResponse.onSuccess(MissionConverter.toCreateMissionResultDto(newMission));
    }

    @PostMapping("/stores/{storesId}/missions/{missionId}")
    public ApiResponse<MissionResponseDTO.ChallengeMissionResultDto> challenge(@RequestBody @Valid MissionRequestDTO.ChallengeMissionDto request, @RequestParam("missionId") Long missionId){
        MemberMission newMemberMission = memberMissionService.challengeMission(request, missionId);
        return ApiResponse.onSuccess(MemberMissionConverter.toChallengeMissionResultDto(newMemberMission));
    }
}
