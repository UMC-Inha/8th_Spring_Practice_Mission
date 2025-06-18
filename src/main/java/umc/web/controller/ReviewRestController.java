package umc.web.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.Parameters;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import umc.apiPayload.ApiResponse;
import umc.converter.ReviewConverter;
import umc.domain.Review;
import umc.service.restaurant.RestaurantQueryService;
import umc.service.review.ReviewCommandService;
import umc.service.review.ReviewQueryService;
import umc.validation.annotation.CheckPage;
import umc.validation.annotation.ExistLocation;
import umc.validation.annotation.ExistRestaurant;
import umc.web.dto.review.ReviewRequestDTO;
import umc.web.dto.review.ReviewResponseDTO;

@RestController
@RequiredArgsConstructor
@RequestMapping("/reviews")
@Validated
public class ReviewRestController {

    private final ReviewCommandService reviewCommandService;
    private final ReviewQueryService reviewQueryService;


    @PostMapping("/{restaurantId}")
    public ApiResponse<String> createReview(
            @RequestBody @Valid ReviewRequestDTO.createReviewDTO request, @ExistLocation @PathVariable Long restaurantId) {

        reviewCommandService.createReview(request, restaurantId);
        return ApiResponse.onSuccess("리뷰가 등록되었습니다");

    }


    @GetMapping("/{restaurantId}")
    @Operation(summary = "특정 가게의 리뷰 목록 조회 API",description = "특정 가게의 리뷰들의 목록을 조회하는 API이며, 페이징을 포함합니다. query String 으로 page 번호를 주세요")
    @ApiResponses({
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "COMMON200",description = "OK, 성공"),
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "AUTH003", description = "access 토큰을 주세요!",content = @Content(schema = @Schema(implementation = ApiResponse.class))),
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "AUTH004", description = "acess 토큰 만료",content = @Content(schema = @Schema(implementation = ApiResponse.class))),
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "AUTH006", description = "acess 토큰 모양이 이상함",content = @Content(schema = @Schema(implementation = ApiResponse.class))),
    })
    @Parameters({
            @Parameter(name = "restaurantId", description = "가게의 아이디, path variable 입니다!")
    })
    public ApiResponse<ReviewResponseDTO.ReviewPreViewListDTO> getReviewList(@ExistRestaurant @PathVariable(name = "restaurantId") Long restaurantId, @CheckPage @RequestParam(name = "page") Integer page){
        Page<Review> reviewList = reviewQueryService.getReviewList(restaurantId,page);
        return ApiResponse.onSuccess(ReviewConverter.toReviewPreViewListDTO(reviewList));
    }



    @GetMapping("")
    @Operation(summary = "특정 유저가 작성한 가게의 리뷰 목록 조회 API",description = "내가 작성한 리뷰들의 목록을 조회하는 API이며, 페이징을 포함합니다. query String 으로 page 번호를 주세요")
    @ApiResponses({
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "COMMON200",description = "OK, 성공"),
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "AUTH003", description = "access 토큰을 주세요!",content = @Content(schema = @Schema(implementation = ApiResponse.class))),
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "AUTH004", description = "acess 토큰 만료",content = @Content(schema = @Schema(implementation = ApiResponse.class))),
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "AUTH006", description = "acess 토큰 모양이 이상함",content = @Content(schema = @Schema(implementation = ApiResponse.class))),
    })

    public ApiResponse<ReviewResponseDTO.ReviewPreViewListDTO> getMyReviewList(@CheckPage @RequestParam(name = "page") Integer page){
        Long userId = 1L; // TODO. SecurityUtils 구현 후 토큰에서 userID 가져오기

        Page<Review> myReviewList = reviewQueryService.getReviewListByUserId(userId, page);
        return ApiResponse.onSuccess(ReviewConverter.toReviewPreViewListDTO(myReviewList));
    }



}
