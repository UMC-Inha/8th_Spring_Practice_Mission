package umc.web.controller.member;

import io.swagger.v3.oas.annotations.Operation;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import umc.apiPayload.ApiResponse;
import umc.converter.member.MemberConverter;
import umc.domain.Member;
import umc.dto.member.MemberRequestDTO;
import umc.dto.member.MemberResponseDTO;
import umc.service.member.MemberService;

@RestController
@RequiredArgsConstructor
@RequestMapping("/members")
public class MemberRestController {

    private final MemberService memberService;

    @PostMapping("/")
    @Operation(summary = "회원가입 API")
    public ApiResponse<MemberResponseDTO.JoinResultDto> join(@RequestBody @Valid MemberRequestDTO.JoinDto request) {
        Member newMember = memberService.joinMember(request);

        return ApiResponse.onSuccess(MemberConverter.toJoinResultDto(newMember));
    }
}
