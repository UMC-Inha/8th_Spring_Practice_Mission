package umc.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import umc.apiPayload.ApiResponse;
import umc.converter.MissionConverter;
import umc.domain.Mission;
import umc.domain.mapping.UserMission;
import umc.dto.MissionDto;
import umc.dto.MissionRequestDto;
import umc.dto.MissionResponseDto;
import umc.dto.UserResponseDto;
import umc.service.MissionService.MissionCommandService;

@RestController
@RequiredArgsConstructor
@RequestMapping("/missions")
public class MissionController {

	private final MissionCommandService missionCommandService;

	@PostMapping
	public ResponseEntity<ApiResponse<MissionResponseDto.JoinResultDto>> joinMission(@RequestBody @Valid MissionRequestDto.JoinMissionDto request){
		Mission mission = missionCommandService.joinMission(request);
		return ResponseEntity.ok(ApiResponse.onSuccess(MissionConverter.toJoinResultDTO(mission)));
	}

	@PostMapping("/challenge")
	public ResponseEntity<ApiResponse<MissionResponseDto.ChallengeResultDto>> challenge(@RequestBody @Valid MissionRequestDto.ChallengeDto request){
		UserMission memberMission = missionCommandService.challengeMission(request);
		return ResponseEntity.ok(ApiResponse.onSuccess(MissionConverter.toChallengeResultDto(memberMission)));
	}
}
