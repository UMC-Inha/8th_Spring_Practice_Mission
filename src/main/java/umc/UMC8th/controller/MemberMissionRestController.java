package umc.UMC8th.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import umc.UMC8th.apiPayload.ApiResponse;
import umc.UMC8th.service.MemberMissionCommandService;



@RestController
@RequiredArgsConstructor
@RequestMapping("/members/missions")
public class MemberMissionRestController {

    private final MemberMissionCommandService memberMissionCommandService;

    @PutMapping("/{memberMissionId}/complete")
    @Operation(summary = "진행중인 미션 완료 처리", description = "진행중인 미션을 완료 상태로 변경합니다.")
    @ApiResponses({
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "COMMON200", description = "요청 성공"),
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "MISSION404", description = "존재하지 않는 미션"),
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "MISSION409", description = "이미 완료된 미션")
    })
    public ApiResponse<Void> completeMission(@PathVariable(name = "memberMissionId") Long memberMissionId) {
        memberMissionCommandService.completeMission(memberMissionId);
        return ApiResponse.onSuccess(null);
    }
}