package umc.controller;

import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.Parameters;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import umc.apiPayload.ApiResponse;
import umc.converter.MissionConverter;
import umc.domain.enums.MissionStatus;
import umc.domain.mapping.UserMission;
import umc.dto.ChallengeMissionDto;
import umc.dto.MissionRequestDto;
import umc.dto.MissionResponseDto;
import umc.service.MissionService.MissionCommandService;
import umc.service.MissionService.MissionQueryService;
import umc.service.UserMissionService.UserMissionFacadeService;
import umc.validation.annotation.CheckPage;

@RequestMapping("/user/missions")
@RestController
@RequiredArgsConstructor
public class UserMissionController {

	private final UserMissionFacadeService userMissionFacadeService;
	private final MissionQueryService missionQueryService;
	private final MissionCommandService missionCommandService;

	@PostMapping
	public ResponseEntity<ChallengeMissionDto> challengeMission(@RequestParam Long userId, @RequestParam Long missionId) {
		ChallengeMissionDto response = userMissionFacadeService.challengeMission(userId, missionId);
		return ResponseEntity.ok(response);
	}

	@GetMapping
	@Operation(summary = "내가 진행 중인 미션 목록 조회", description = "내가 진행 중인 미션 목록을 조회하는 API")
	@ApiResponses({
		@io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "COMMON200", description = "OK, 성공"),
		@io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "PAGE4001", description = "페이징 번호가 유효하지 않습니다.", content = @Content(schema = @Schema(implementation = ApiResponse.class))),
	})
	@Parameters({
		@Parameter(name = "userId", description = "userId, 쿼리 스트링입니다."),
		@Parameter(name = "status", description = "status, 쿼리 스트링입니다."),
		@Parameter(name = "page", description = "page, 쿼리 스트링입니다.")
	})
	public ApiResponse<MissionResponseDto.UserMissionListDto> getUserMissionList(
		@RequestParam(name = "userId") Long userId,
		@RequestParam(name = "status") MissionStatus status,
		@CheckPage @RequestParam(name = "page") Integer page) {
		Page<UserMission> missionList = missionQueryService.getUserMissionList(userId, status, page - 1);
		return ApiResponse.onSuccess(MissionConverter.toUserMissionListDto(missionList));
	}

	@PatchMapping("/complete")
	@Operation(summary = "미션 완료", description = "내가 진행 중인 미션을 완료 상태로 변경합니다.")
	@ApiResponses({
		@io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "COMMON200", description = "OK, 성공"),
		@io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "MEMBER4001", description = "존재하지 않는 유저입니다.", content = @Content(schema = @Schema(implementation = ApiResponse.class))),
	})
	public ApiResponse<MissionResponseDto.CompleteResultDto> complete(@RequestBody @Valid MissionRequestDto.CompleteRequestDto request) {
		UserMission UserMission = missionCommandService.completeMission(request);
		return ApiResponse.onSuccess(MissionConverter.toCompleteResultDto(UserMission));
	}
}
