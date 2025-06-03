package umc.study.web.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.Parameters;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Min;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;
import umc.study.apiPayload.ApiResponse;
import umc.study.converter.MemberMissionConverter;
import umc.study.converter.StoreConverter;
import umc.study.domain.Mission;
import umc.study.domain.mapping.MemberMission;
import umc.study.service.MemberMissionService.MemberMissionCommandService;
import umc.study.service.MemberMissionService.MemberMissionQueryService;
import umc.study.validation.annotation.ExistStores;
import umc.study.web.dto.MemberMissionDTO.MemberMissionResponseDTO;
import umc.study.web.dto.MissionChallengeDTO.MissionChallengeRequestDTO;
import umc.study.web.dto.MissionChallengeDTO.MissionChallengeResponseDTO;
import umc.study.web.dto.MissionDTO.MissionResponseDTO;

@RestController
@RequiredArgsConstructor
@RequestMapping("/missions")
public class MemberMissionRestController {
    private final MemberMissionCommandService memberMissionCommandService;
    private final MemberMissionQueryService memberMissionQueryService;

    @PostMapping("/challenge")
    public ApiResponse<MissionChallengeResponseDTO.MissionChallengeJoinResultDTO> joinMemberMission(@RequestBody @Valid MissionChallengeRequestDTO.MissionChallengeJoinDTO request) {
        MissionChallengeResponseDTO.MissionChallengeJoinResultDTO response = memberMissionCommandService.challengeMission(request);
        return ApiResponse.onSuccess(response);
    }

    @GetMapping("/challenge/{memberId}")
    @Operation(summary = "유저의 진행 중인 미션 목록 조회 API", description = "유저의 진행 중인 미션들의 목록을 조회하는 API이며, 페이징을 포함합니다. query String 으로 page 번호를 주세요")
    @ApiResponses({
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "COMMON200",description = "OK, 성공"),
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "AUTH003", description = "access 토큰을 주세요!",content = @Content(schema = @Schema(implementation = ApiResponse.class))),
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "AUTH004", description = "acess 토큰 만료",content = @Content(schema = @Schema(implementation = ApiResponse.class))),
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "AUTH006", description = "acess 토큰 모양이 이상함",content = @Content(schema = @Schema(implementation = ApiResponse.class))),
    })
    @Parameters({
            @Parameter(name = "memberId", description = "유저의 아이디, path variable 입니다!")
    })
    public ApiResponse<MemberMissionResponseDTO.MemberMissionPreViewListDTO> getMemberMissionList(@ExistStores @PathVariable(name = "memberId") Long memberId, @RequestParam(name = "page") @Min(value = 1, message = "페이지는 1 이상이어야 합니다.") Integer page) {
        Page<MemberMission> memberMissionList = memberMissionQueryService.getMemberMissionList(memberId, page - 1);
        return ApiResponse.onSuccess(MemberMissionConverter.memberMissionPreViewListDTO(memberMissionList));
    }

    @PatchMapping("/{memberMissionId}/done")
    @Operation(summary = "진행 중인 미션을 진행 완료로 바꾸는 API", description = "진행 중인 미션을 진행 완료로 바꾸는 API입니다.")
    @ApiResponses({
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "COMMON200",description = "OK, 성공"),
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "AUTH003", description = "access 토큰을 주세요!",content = @Content(schema = @Schema(implementation = ApiResponse.class))),
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "AUTH004", description = "acess 토큰 만료",content = @Content(schema = @Schema(implementation = ApiResponse.class))),
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "AUTH006", description = "acess 토큰 모양이 이상함",content = @Content(schema = @Schema(implementation = ApiResponse.class))),
    })
    @Parameters({
            @Parameter(name = "memberMissionId", description = "유저미션의 아이디, path variable 입니다!")
    })
    public ApiResponse<?> completeMission(@PathVariable(name = "memberMissionId") Long memberMissionId) {
        memberMissionCommandService.completeMission(memberMissionId);
        return ApiResponse.onSuccess("미션 수행 완료되었습니다.");
    }
}
