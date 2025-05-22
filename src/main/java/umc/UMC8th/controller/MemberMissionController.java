package umc.UMC8th.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import umc.UMC8th.apiPayload.ApiResponse;
import umc.UMC8th.domain.mapping.MemberMission;
import umc.UMC8th.dto.MissionChallengeRequest;
import umc.UMC8th.service.MemberMissionCommandService;

@RestController
@RequiredArgsConstructor
@RequestMapping("/missions")
public class MemberMissionController {

    private final MemberMissionCommandService commandService;

    @PostMapping("/challenges")
    public ApiResponse<String> challenge(@RequestBody @Valid MissionChallengeRequest request) {
        MemberMission result = commandService.challengeMission(request);
        return ApiResponse.onSuccess("미션 도전을 완료하셨습니다. id = " + result.getId());
    }
}
