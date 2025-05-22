package umc.study.web.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import umc.study.apiPayload.ApiResponse;
import umc.study.service.MemberMissionService.MemberMissionCommandService;
import umc.study.web.dto.MissionChallengeDTO.MissionChallengeRequestDTO;
import umc.study.web.dto.MissionChallengeDTO.MissionChallengeResponseDTO;

@RestController
@RequiredArgsConstructor
@RequestMapping("/missions/challenge")
public class MemberMissionRestController {
    private final MemberMissionCommandService memberMissionCommandService;

    @PostMapping("/")
    public ApiResponse<MissionChallengeResponseDTO.MissionChallengeJoinResultDTO> joinMemberMission(@RequestBody @Valid MissionChallengeRequestDTO.MissionChallengeJoinDTO request) {
        MissionChallengeResponseDTO.MissionChallengeJoinResultDTO response = memberMissionCommandService.challengeMission(request);
        return ApiResponse.onSuccess(response);
    }
}
