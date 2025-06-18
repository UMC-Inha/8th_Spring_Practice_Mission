package umc.spring.web.controller;


import io.swagger.v3.oas.annotations.Operation;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;
import umc.spring.apiPayload.ApiResponse;
import umc.spring.converter.MemberMissionConverter;
import umc.spring.converter.MissionConverter;
import umc.spring.converter.ReviewConverter;
import umc.spring.domain.Mission;
import umc.spring.domain.Review;
import umc.spring.domain.mapping.MemberMission;
import umc.spring.service.memberMissionService.MemberMissionService;
import umc.spring.service.missionService.MissionService;
import umc.spring.web.dto.memberMission.MemberMissionResponseDTO;
import umc.spring.web.dto.mission.MissionRequestDTO;
import umc.spring.web.dto.mission.MissionResponseDTO;
import umc.spring.web.dto.review.ReviewResponseDTO;

@RestController
@RequiredArgsConstructor
@RequestMapping("/")
public class MissionRestController {

    private final MissionService missionService;
    private final MemberMissionService memberMissionService;

    @PostMapping("/stores/{storesId}/missions")
    @Operation(summary = "미션 생성")
    public ApiResponse<MissionResponseDTO.CreateMissionResultDto> create(@RequestBody @Valid MissionRequestDTO.CreateMissionDTO request, @RequestParam("storeId") Long storeId){
        Mission newMission = missionService.CreateMission(request, storeId);
        return ApiResponse.onSuccess(MissionConverter.toCreateMissionResultDto(newMission));
    }

    @PostMapping("/stores/{storesId}/missions/{missionId}")
    @Operation(summary = "미션 도전")
    public ApiResponse<MissionResponseDTO.ChallengeMissionResultDto> challenge(@RequestBody @Valid MissionRequestDTO.ChallengeMissionDto request, @RequestParam("missionId") Long missionId){
        MemberMission newMemberMission = memberMissionService.challengeMission(request, missionId);
        return ApiResponse.onSuccess(MemberMissionConverter.toChallengeMissionResultDto(newMemberMission));
    }

    @GetMapping("/missions/mypage")
    @Operation(summary = "내가 진행중인 미션 목록")
    public ApiResponse<MemberMissionResponseDTO.PreviewMyMissionListDto> getMissionList(@RequestParam(name = "memberId") Long memberId, @RequestParam(name = "page") Integer page) {
        Page<MemberMission> memberMissionList = memberMissionService.getMissionListByMember(memberId, page);
        return ApiResponse.onSuccess(MemberMissionConverter.PreviewMyMissionResultListDto(memberMissionList));
    }

    @PatchMapping("/missions/{missionId}")
    @Operation(summary = "진행중인 미션 완료로 바꾸기 API")
    public ApiResponse<MemberMissionResponseDTO.ChangeMissionStatusByMemberDto> changeMissionStatusByMember (@PathVariable("missionId") Long missionId, @RequestParam("memberId") Long memberId) {
        MemberMission memberMission = memberMissionService.changeMissionStatusByMember(missionId, memberId);
        return ApiResponse.onSuccess(MemberMissionConverter.toChangeMissionStatusByMemberDto(memberMission));
    }
}
