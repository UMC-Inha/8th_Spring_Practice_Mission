package umc.study.web.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import umc.study.apiPayload.ApiResponse;
import umc.study.converter.MemberMissionConverter;
import umc.study.domain.enums.MissionStatus;
import umc.study.domain.mapping.MemberMission;
import umc.study.service.MemberService.MemberMissionCommandService;
import umc.study.web.dto.Mission.MemberMissionRequestDto;
import umc.study.web.dto.Mission.MemberMissionResponseDto;

@RestController
@RequiredArgsConstructor
@Validated
@RequestMapping("/memberMissions")
public class MemberMissionRestController {

    private final MemberMissionCommandService memberMissionCommandService;

    @PostMapping("")
    public ApiResponse<MemberMissionResponseDto.JoinResultDTO> joinMemberMission(@RequestBody @Valid MemberMissionRequestDto.JoinDto request){
        MemberMission memberMission = memberMissionCommandService.joinMemberMission(request);
        return ApiResponse.onSuccess(MemberMissionConverter.toJoinResultDTO(memberMission));
    }

    @PostMapping("/{memberMissionId}/complete")
    public ApiResponse<String> completeMemberMission(@PathVariable("memberMissionId") Long memberMissionId){
        memberMissionCommandService.changeMemberMissionStatus(memberMissionId, MissionStatus.COMPLETE);
        return ApiResponse.onSuccess("미션을 완료했습니다.");
    }
}
