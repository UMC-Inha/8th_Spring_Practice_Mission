package umc.controller;

import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
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
import umc.converter.RestaurantConverter;
import umc.converter.ReviewConverter;
import umc.domain.Mission;
import umc.domain.Restaurant;
import umc.domain.Review;
import umc.dto.MissionResponseDto;
import umc.dto.RestaurantRequestDto;
import umc.dto.RestaurantResponseDto;
import umc.dto.ReviewResponseDto;
import umc.service.MissionService.MissionQueryService;
import umc.service.RestaurantService.RestaurantCommandService;
import umc.service.ReviewService.ReviewQueryService;
import umc.validation.annotation.CheckPage;
import umc.validation.annotation.ExistRestaurant;

@RestController
@RequiredArgsConstructor
@RequestMapping("/restaurants")
public class RestaurantController {

	private final RestaurantCommandService restaurantCommandService;
	private final ReviewQueryService reviewQueryService;
	private final MissionQueryService missionQueryService;

	@PostMapping
	public ResponseEntity<ApiResponse<RestaurantResponseDto.JoinResultDto>> join(@RequestBody @Valid RestaurantRequestDto.JoinDto request){
		Restaurant restaurant = restaurantCommandService.joinRestaurant(request);
		return ResponseEntity.ok(ApiResponse.onSuccess(RestaurantConverter.toJoinResultDto(restaurant)));
	}

	@GetMapping("/{restaurantId}/reviews/my")
	@Operation(summary = "내가 작성한 리뷰 목록 조회", description = "특정 가게에서 내가 작성한 리뷰 목록을 조회하는 API")
	@ApiResponses({
		@io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "COMMON200", description = "OK, 성공"),
		@io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "RESTAURANT4001", description = "식당이 존재하지 않습니다." ,content = @Content(schema = @Schema(implementation = ApiResponse.class))),
		@io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "PAGE4001", description = "페이징 번호가 유효하지 않습니다.", content = @Content(schema = @Schema(implementation = ApiResponse.class))),
	})
	@Parameters({
		@Parameter(name = "restaurantId", description = "restaurantId, path variable 입니다."),
		@Parameter(name = "userId", description = "userId, 쿼리 스트링입니다."),
		@Parameter(name = "page", description = "page, 쿼리 스트링입니다.")
	})
	public ApiResponse<ReviewResponseDto.ReviewListDto> getReviewList(
		@ExistRestaurant @PathVariable(name = "restaurantId") Long restaurantId,
		@RequestParam(name = "userId") Long userId,
		@CheckPage @RequestParam(name = "page") Integer page) {
		Page<Review> reviewList = reviewQueryService.getMyReviewList(restaurantId, userId, page - 1);
		return ApiResponse.onSuccess(ReviewConverter.toReviewListDto(reviewList));
	}

	@GetMapping("/{restaurantId}/missions")
	@Operation(summary = "수행 가능한 미션 목록 조회", description = "특정 가게에서 수행 가능한 미션 목록을 조회하는 API")
	@ApiResponses({
		@io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "COMMON200", description = "OK, 성공"),
		@io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "RESTAURANT4001", description = "식당이 존재하지 않습니다." ,content = @Content(schema = @Schema(implementation = ApiResponse.class))),
		@io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "PAGE4001", description = "페이징 번호가 유효하지 않습니다.", content = @Content(schema = @Schema(implementation = ApiResponse.class))),
	})
	@Parameters({
		@Parameter(name = "restaurantId", description = "restaurantId, path variable 입니다."),
		@Parameter(name = "userId", description = "userId, 쿼리 스트링입니다."),
		@Parameter(name = "page", description = "page, 쿼리 스트링입니다.")
	})
	public ApiResponse<MissionResponseDto.MissionListDto> getMissionList(
		@ExistRestaurant @PathVariable(name = "restaurantId") Long restaurantId,
		@RequestParam(name = "userId") Long userId,
		@CheckPage @RequestParam(name = "page") Integer page) {
		Page<Mission> missionList = missionQueryService.getRestaurantMissionList(restaurantId, userId, page - 1);
		return ApiResponse.onSuccess(MissionConverter.toMissionListDto(missionList));
	}
}
