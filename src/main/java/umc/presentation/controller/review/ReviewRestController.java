package umc.presentation.controller.review;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.Parameters;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import umc.application.converter.ReviewConverter;
import umc.application.service.review.ReviewCommandService;
import umc.application.service.review.ReviewQueryService;
import umc.common.ApiPayload.ApiResponse;
import umc.common.validation.annotation.ExistStore;
import umc.common.validation.annotation.ExistUser;
import umc.presentation.dto.ResponseEntityUtil;
import umc.presentation.dto.review.ReviewRequestDto;
import umc.presentation.dto.review.ReviewResponseDto;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/reviews")
public class ReviewRestController {
    private final ReviewCommandService reviewCommandService;
    private final ReviewQueryService reviewQueryService;

    @GetMapping("/{storeId}/reviews")
    @Operation(summary = "특정 가게의 리뷰 목록 조회 API",description = "특정 가게의 리뷰들의 목록을 조회하는 API이며, 페이징을 포함합니다. query String 으로 page 번호를 주세요")
    @ApiResponses({
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "COMMON200",description = "OK, 성공"),
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "AUTH003", description = "access 토큰을 주세요!",content = @Content(schema = @Schema(implementation = ApiResponse.class))),
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "AUTH004", description = "acess 토큰 만료",content = @Content(schema = @Schema(implementation = ApiResponse.class))),
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "AUTH006", description = "acess 토큰 모양이 이상함",content = @Content(schema = @Schema(implementation = ApiResponse.class))),
    })
    @Parameters({
            @Parameter(name = "storeId", description = "가게의 아이디, path variable 입니다!")
    })
    public ResponseEntity<ApiResponse<?>> getReviewList(@ExistStore @PathVariable(name="storeId") Long storeId, @RequestParam(name = "page") Integer page){
        return ResponseEntityUtil.buildDefaultResponseEntity(ApiResponse.onSuccess(
                ReviewConverter.toReviewPreviewListDto(reviewQueryService.getReviewList(storeId, page))
        ));
    }
    @GetMapping("/{userId}/reviews")
    public ResponseEntity<ApiResponse<?>> getReviewByUserId(@ExistUser @PathVariable(name = "userId") Long userId, @RequestParam(name = "page") Integer page) {
        return ResponseEntityUtil.buildDefaultResponseEntity(ApiResponse.onSuccess(
                ReviewConverter.toReviewPreviewListDto(reviewQueryService.getReviewListByUserId(userId, page))
        ));
    }


    @PostMapping("")
    public ResponseEntity<ApiResponse<?>> CreateReview(@RequestBody @Valid ReviewRequestDto.CreateReviewRequestDto requestDto) {
        return ResponseEntityUtil.buildResponseEntityWithStatus(
                ApiResponse.onSuccess( reviewCommandService.createReview(requestDto)), HttpStatus.CREATED);
    }
}
