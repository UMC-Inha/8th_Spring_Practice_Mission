package umc.web.controller.member;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
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

    @PostMapping("/login")
    @Operation(summary = "User Login API", description = "유저가 로그인하는 API")
    public ApiResponse<MemberResponseDTO.LoginResultDTO> login(@RequestBody MemberRequestDTO.LoginRequestDTO request) {
        return ApiResponse.onSuccess(memberService.loginMember(request));
    }

    @GetMapping("/info")
    @Operation(summary = "유저 내 정보 조회 API - 인증 필요",
    description = "유저가 내 정보를 조회하는 API",
    security = {@SecurityRequirement(name = "JWT TOKEN")})
    public ApiResponse<MemberResponseDTO.MemberInfoDTO> getMyInfo(HttpServletRequest request) {
        return ApiResponse.onSuccess(memberService.getMemberInfo(request));
    }
}
