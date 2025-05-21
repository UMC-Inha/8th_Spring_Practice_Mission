package umc.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import umc.apiPayload.ApiResponse;
import umc.converter.UserConverter;
import umc.domain.User;
import umc.dto.UserRequestDto;
import umc.dto.UserResponseDto;
import umc.dto.WithdrawUserDto;
import umc.service.UserService.UserCommandServiceImpl;

@RequestMapping("/users")
@RestController
@RequiredArgsConstructor
public class UserController {

	private final UserCommandServiceImpl userCommandService;

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
}
