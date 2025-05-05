package umc.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;
import umc.dto.ChallengeMissionDto;
import umc.service.UserMissionFacadeService;
import umc.service.UserMissionService;

@RequestMapping("/user/missions")
@RestController
@RequiredArgsConstructor
public class UserMissionController {

	private final UserMissionFacadeService userMissionFacadeService;

	@PostMapping
	public ResponseEntity<ChallengeMissionDto> challengeMission(@RequestParam Long userId, @RequestParam Long missionId) {
		ChallengeMissionDto response = userMissionFacadeService.challengeMission(userId, missionId);
		return ResponseEntity.ok(response);
	}
}
