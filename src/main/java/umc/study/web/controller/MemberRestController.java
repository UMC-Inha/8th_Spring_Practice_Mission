package umc.study.web.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import umc.study.apiPayload.ApiResponse;
import umc.study.apiPayload.validation.annotation.ValidPageableIndex;
import umc.study.converter.MemberConverter;
import umc.study.domain.Member;
import umc.study.domain.enums.MissionStatus;
import umc.study.service.MemberService.MemberCommandService;
import umc.study.web.dto.Member.MemberRequestDTO;
import umc.study.web.dto.Member.MemberResponseDTO;
import umc.study.web.dto.Mission.MemberMissionResponseDto;

@RestController
@RequiredArgsConstructor
@Validated
@RequestMapping("/members")
public class MemberRestController {

    private final MemberCommandService memberCommandService;

    @GetMapping("/{memberId}/missions")
    public ApiResponse<Page<MemberMissionResponseDto.JoinResultDTO>> getMemberMissions(
            @ValidPageableIndex
            @PageableDefault(size = 10, sort = "createdAt", direction = Sort.Direction.DESC)
            Pageable pageable,
            @RequestParam MissionStatus status,
            @PathVariable("memberId") Long memberId
    ) {
        return ApiResponse.onSuccess(memberCommandService.findMemberMissions(memberId, status, pageable));
    }

    @PostMapping("/")
    public ApiResponse<MemberResponseDTO.JoinResultDTO> join(@RequestBody @Valid MemberRequestDTO.JoinDto request){
        Member member = memberCommandService.joinMember(request);
        return ApiResponse.onSuccess(MemberConverter.toJoinResultDTO(member));
    }
}
