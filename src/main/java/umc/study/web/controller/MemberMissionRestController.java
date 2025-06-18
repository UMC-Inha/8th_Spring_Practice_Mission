package umc.study.web.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import umc.study.apiPayload.ApiResponse;
import umc.study.converter.MemberMissionConverter;
import umc.study.domain.enums.MissionStatus;
import umc.study.domain.mapping.MemberMission;
import umc.study.service.MemberMissionService.MemberMissionCommandService;
import umc.study.service.MemberMissionService.MemberMissionQueryService;
import umc.study.validation.annotation.ExistMember;
import umc.study.validation.annotation.ExistMemberMission;
import umc.study.web.dto.request.MemberMissionRequestDTO;
import umc.study.web.dto.response.MemberMissionResponseDTO;

import java.time.LocalDateTime;
import java.util.List;

@Validated
@RestController
@RequestMapping("/api/v1/missions")
@Tag(name = "멤버미션 API")
@RequiredArgsConstructor
public class MemberMissionRestController {
    private final MemberMissionCommandService memberMissionCommandService;
    private final MemberMissionQueryService memberMissionQueryService;

    @PostMapping("/challenge")
    public ApiResponse<MemberMissionResponseDTO.challengeResultDTO> challengeMission(@RequestBody @Valid MemberMissionRequestDTO.createChallengeDTO request) {
        MemberMission memberMission = memberMissionCommandService.createMemberMission(request);
        return ApiResponse.onSuccess(MemberMissionConverter.toChallengeResultDTO(memberMission));
    }

    //TODO: 마찬가지로 jwt 토큰에서 사용자 정보 빼내오도록 향후 수정...
    @GetMapping("/me")
    @Operation(summary = "내 미션 커서 기반 조회", description = "사용자의 진행중 또는 완료한 미션을 커서 기반으로 조회합니다.")
    public ApiResponse<MemberMissionResponseDTO.MyMemberMissionSliceDTO> getMyMissionsCursor(
            @RequestParam @ExistMember Long userId,
            @RequestParam MissionStatus missionStatus,
            @RequestParam(required = false) @ExistMemberMission Long cursorId,
            @RequestParam(required = false) @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDateTime cursorCreatedAt
    ) {
        List<MemberMissionResponseDTO.MyMemberMissionDTO> myMemberMissionDTOList = memberMissionQueryService.getMyMissionsByCursor(userId, missionStatus, cursorId, cursorCreatedAt, 10);
        return ApiResponse.onSuccess(MemberMissionConverter.toMyMemberMissionSliceDTO(myMemberMissionDTOList, 10));
    }
}
