package umc.study.web.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import umc.study.apiPayload.ApiResponse;
import umc.study.converter.MemberMissionConverter;
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
}
