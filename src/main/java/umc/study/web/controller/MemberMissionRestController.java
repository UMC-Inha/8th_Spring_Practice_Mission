package umc.study.web.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import umc.study.apiPayload.ApiResponse;
import umc.study.converter.MemberMissionConverter;
import umc.study.domain.mapping.MemberMission;
import umc.study.service.MemberMissionService.MemberMissionCommandService;
import umc.study.web.dto.MemberMissionRequestDTO;
import umc.study.web.dto.MemberMissionResponseDTO;

@Validated
@RestController
@RequiredArgsConstructor
public class MemberMissionRestController {
    private final MemberMissionCommandService memberMissionCommandService;

    @PostMapping("/api/v1/missions/challenge")
    public ApiResponse<MemberMissionResponseDTO.challengeResultDTO> challengeMission(@RequestBody @Valid MemberMissionRequestDTO.createChallengeDTO request) {
        MemberMission memberMission = memberMissionCommandService.createMemberMission(request);
        return ApiResponse.onSuccess(MemberMissionConverter.toChallengeResultDTO(memberMission));
    }
}
