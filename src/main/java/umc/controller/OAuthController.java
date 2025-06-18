package umc.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;
import umc.apiPayload.ApiResponse;
import umc.dto.UserResponseDto;
import umc.service.AuthService;

@RestController
@RequiredArgsConstructor
public class OAuthController {

	private final AuthService authService;

	@GetMapping("/auth/login/kakao")
	public ResponseEntity<ApiResponse<UserResponseDto.LoginResultDTO>> kakaoLogin(@RequestParam("code") String accessCode) {
		UserResponseDto.LoginResultDTO response = authService.oAuthLogin(accessCode);
		return ResponseEntity.ok(ApiResponse.onSuccess(response));
	}
}
