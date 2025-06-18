package umc.presentation.controller.user;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import umc.application.service.user.UserCommandService;
import umc.application.service.user.UserQueryService;
import umc.common.ApiPayload.ApiResponse;
import umc.presentation.dto.ResponseEntityUtil;
import umc.presentation.dto.user.UserRequestDTO;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/users")
public class UserRestController {
    private final UserCommandService userCommandService;
    private final UserQueryService userQueryService;

    @PostMapping("/join")
    public ResponseEntity<ApiResponse<?>> join(@RequestBody @Valid UserRequestDTO.JoinDto request) {
        return ResponseEntityUtil.buildResponseEntityWithStatus(
                ApiResponse.onSuccess(userCommandService.joinUser(request)), HttpStatus.CREATED);
    }

    @PostMapping("/login")
    @Operation(summary = "유저 로그인 API", description = "유저 로그인 API")
    public ResponseEntity<ApiResponse<?>> login(@RequestBody @Valid UserRequestDTO.LoginRequestDto request) {
        return ResponseEntityUtil.buildDefaultResponseEntity(ApiResponse.onSuccess(userCommandService.loginUser(request)));
    }

    @GetMapping("/info")
    @Operation(summary = "유저 내 정보 조회 API - 인증 필요",
            description = "유저가 내 정보를 조회하는 API입니다.",
            security = { @SecurityRequirement(name = "JWT TOKEN") }
    )
    public ResponseEntity<ApiResponse<?>> getMyInfo(HttpServletRequest request){
        return ResponseEntityUtil.buildDefaultResponseEntity(ApiResponse.onSuccess(userQueryService.getUserInfo(request)));
    }
}
