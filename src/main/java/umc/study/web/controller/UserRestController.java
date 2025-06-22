package umc.study.web.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;
import umc.study.apiPayload.ApiResponse;
import umc.study.converter.UserConverter;
import umc.study.domain.User;
import umc.study.service.MissionService.MissionCommandServiceImpl;
import umc.study.service.UserService.UserCommandService;
import umc.study.service.UserService.UserQueryService;
import umc.study.web.dto.UserRequestDto;
import umc.study.web.dto.UserResponseDto;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/users")
public class UserRestController {
    private final UserCommandService userCommandService;
    private final UserQueryService userQueryService;

    @PostMapping("/join")
    @Operation(summary = "유저 회원가입 API",description = "유저가 회원가입하는 API입니다.")
    public ApiResponse<UserResponseDto.JoinResultDTO> join(@RequestBody @Valid UserRequestDto.JoinDto request){
        User user = userCommandService.joinUser(request);
        return ApiResponse.onSuccess(UserConverter.toJoinResultDTO(user));
    }

    @PostMapping("/login")
    @Operation(summary = "유저 로그인 API",description = "유저가 로그인하는 API입니다.")
    public ApiResponse<UserResponseDto.LoginResultDTO> login(@RequestBody @Valid UserRequestDto.LoginRequestDTO request) {
        return ApiResponse.onSuccess(userCommandService.loginUser(request));
    }

    @GetMapping("/info")
    @Operation(summary = "유저 내 정보 조회 API - 인증 필요",
            description = "유저가 내 정보를 조회하는 API입니다.",
            security = { @SecurityRequirement(name = "JWT TOKEN") }
    )
    public ApiResponse<UserResponseDto.UserInfoDTO> getMyInfo(HttpServletRequest request) {
        return ApiResponse.onSuccess(userQueryService.getUserInfo(request));
    }
}
