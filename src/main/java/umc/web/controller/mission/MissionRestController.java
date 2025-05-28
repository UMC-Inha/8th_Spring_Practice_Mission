package umc.web.controller.mission;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.Parameters;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;
import umc.apiPayload.ApiResponse;
import umc.converter.memberMission.MemberMissionConverter;
import umc.converter.mission.MissionConverter;
import umc.domain.Mission;
import umc.domain.enums.MissionStatus;
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

    @GetMapping("/restaurants/{restaurantId}/missions")
    @Operation(summary = "특정 가게 미션 목록 조회 API")
    @Parameters({
            @Parameter(name = "restaurantId", description = "가게의 아이디, path variable 입니다!")
    })
    public ApiResponse<MissionResponseDTO.PreviewRestaurantMissionListDto> previewMissionByRestaurant(@PathVariable("restaurantId") Long restaurantId,
                                                                                                      @RequestParam("page") Integer page) {
        Page<Mission> missionList = missionService.previewMissionByRestaurant(restaurantId, page);
        return ApiResponse.onSuccess(MissionConverter.previewRestaurantMissionListDto(missionList));
    }

    @GetMapping("/mypage/missions")
    @Operation(summary = "특정 멤버 진행중인 미션 목록 조회 API")
    public ApiResponse<MissionResponseDTO.PreviewMemberMissionListDto> previewMissionByMember(@RequestParam("memberId") Long memberId,
                                                                                              @RequestParam("missionStatus") MissionStatus missionStatus,
                                                                                              @RequestParam("page") Integer page) {
        Page<MemberMission> memberMissionList = memberMissionService.previewMissionByMemberAndStatus(memberId, missionStatus, page);
        return ApiResponse.onSuccess(MemberMissionConverter.previewMemberMissionListDto(memberMissionList));
    }

    @PatchMapping("/missions/{missionId}")
    @Operation(summary = "진행중인 미션 완료로 바꾸기 API")
    public ApiResponse<MissionResponseDTO.ChangeMissionStatusByMemberDto> changeMissionStatusByMember (@PathVariable("missionId") Long missionId,
                                                                                                       @RequestParam("memberId") Long memberId) {
        MemberMission memberMission = memberMissionService.changeMissionStatusByMember(missionId, memberId);
        return ApiResponse.onSuccess(MemberMissionConverter.toChangeMissionStatusByMemberDto(memberMission));
    }
}
