package umc.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;
import umc.dto.WithdrawUserDto;
import umc.service.UserService;

@RequestMapping("/user")
@RestController
@RequiredArgsConstructor
public class UserController {

	private final UserService userService;

	@DeleteMapping("/withdraw")
	public ResponseEntity<WithdrawUserDto> withdrawUser(Long userId) {
		WithdrawUserDto response = userService.withdrawUser(userId);
		return ResponseEntity.ok(response);
	}
}
