package umc.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import umc.apiPayload.ApiResponse;
import umc.dto.UserRequestDto;
import umc.dto.UserResponseDto;
import umc.dto.WithdrawUserDto;
import umc.service.UserService.UserCommandServiceImpl;
import umc.service.UserService.UserQueryService;

@RequestMapping("/users")
@RestController
@RequiredArgsConstructor
public class UserRestController {

	private final UserCommandServiceImpl userCommandService;
	private final UserQueryService userQueryService;

	@PostMapping("/")
	public ResponseEntity<ApiResponse<UserResponseDto.JoinResultDTO>> join(@RequestBody @Valid UserRequestDto.JoinDto request) {
		UserResponseDto.JoinResultDTO response = userCommandService.joinUser(request);
		return ResponseEntity.ok(ApiResponse.onSuccess(response));
	}

	@DeleteMapping("/withdraw")
	public ResponseEntity<WithdrawUserDto> withdrawUser(@RequestParam Long userId) {
		WithdrawUserDto response = userCommandService.withdrawUser(userId);
		return ResponseEntity.ok(response);
	}

	@PostMapping("/login")
	@Operation(summary = "유저 로그인 API",description = "유저가 로그인하는 API입니다.")
	public ResponseEntity<ApiResponse<UserResponseDto.LoginResultDTO>> login(@RequestBody @Valid UserRequestDto.LoginRequestDto request) {
		UserResponseDto.LoginResultDTO response = userCommandService.loginUser(request);
		return ResponseEntity.ok(ApiResponse.onSuccess(response));
	}

	@GetMapping("/info")
	@Operation(summary = "유저 내 정보 조회 API - 인증 필요",
		description = "유저가 내 정보를 조회하는 API입니다."
	)
	public ResponseEntity<ApiResponse<UserResponseDto.UserInfoDTO>> getMyInfo(Authentication authentication) {
		UserResponseDto.UserInfoDTO response = userQueryService.getUserInfo(authentication);
		return ResponseEntity.ok(ApiResponse.onSuccess(response));
	}

	@PostMapping("/signup")
	@Operation(summary = "유저 회원가입 API",description = "유저가 회원가입하는 API입니다.")
	public ResponseEntity<ApiResponse<UserResponseDto.JoinResultDTO>> signup(@RequestBody @Valid UserRequestDto.JoinDto request) {
		UserResponseDto.JoinResultDTO response = userCommandService.joinUser(request);
		return ResponseEntity.ok(ApiResponse.onSuccess(response));
	}

	@PostMapping("/reissue")
	@Operation(summary = "액세스 토큰 재발급 API",description = "토큰 재발급 API입니다.")
	public ResponseEntity<ApiResponse<UserResponseDto.ReissueDto>> reissue(@RequestBody @Valid UserRequestDto.ReissueDto request) {
		UserResponseDto.ReissueDto response = userCommandService.reissue(request);
		return ResponseEntity.ok(ApiResponse.onSuccess(response));
	}
}
