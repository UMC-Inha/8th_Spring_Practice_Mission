package umc.study.web.controller.member;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import umc.study.apiPayload.ApiResponse;
import umc.study.service.member.MemberCommandServiceImpl;
import umc.study.service.member.MemberQueryService;
import umc.study.web.controller.member.dto.MemberRequestDTO;
import umc.study.web.controller.member.dto.MemberResponseDTO;
import umc.study.web.converter.member.MemberConverter;

import static umc.study.web.controller.member.dto.MemberRequestDTO.*;
import static umc.study.web.controller.member.dto.MemberResponseDTO.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/members")
public class MemberRestController {
    private final MemberCommandServiceImpl memberCommandService;
    private final MemberQueryService memberQueryService;

    // 회원가입
    @PostMapping("/join")
    @Operation(summary = "유저 회원가입 API", description = "유저가 회원가입하는 API입니다.")
    public ResponseEntity<?> join(@RequestBody @Valid JoinDto request) {
        return ResponseEntity.ok(MemberConverter.toJoinResultDTO(memberCommandService.joinMember(request)));
    }

    @PostMapping("/login")
    @Operation(summary = "유저 로그인 API",description = "유저가 로그인하는 API입니다.")
    public ApiResponse<LoginResultDTO> login(@RequestBody @Valid LoginRequestDTO request) {
        return ApiResponse.onSuccess(memberCommandService.loginMember(request));
    }

    @GetMapping("/info")
    @Operation(summary = "유저 내 정보 조회 API - 인증 필요",
            description = "유저가 내 정보를 조회하는 API입니다.",
            security = { @SecurityRequirement(name = "JWT TOKEN") }
    )
    public ApiResponse<MemberInfoDTO> getMyInfo(HttpServletRequest request) {
        return ApiResponse.onSuccess(memberQueryService.getMemberInfo(request));
    }
}
