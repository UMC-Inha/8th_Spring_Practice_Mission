package umc.study.web.controller;

import io.swagger.v3.oas.annotations.Operation;
import jakarta.validation.Valid;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Slice;
import org.springframework.web.bind.annotation.*;
import umc.study.apiPayload.ApiResponse;
import umc.study.converter.ReviewConverter;
import umc.study.domain.review.Review;
import umc.study.service.review.ReviewCommandService;
import umc.study.validation.annotation.ValidatedPage;
import umc.study.web.dto.request.ReviewRequestDto;
import umc.study.web.dto.response.ReviewResponseDto;

@RestController
@RequiredArgsConstructor
@RequestMapping("/reviews")
public class ReviewRestController {

    private final ReviewCommandService reviewCommandService;

    @GetMapping("/users/{userId}")
    @Operation(summary = "사용자 작성 리뷰 목록 조회 API", description = "사용자가 작성한 리뷰 목록 조회 API 입니다. 페이징을 포함하고 있으며 page, size 값을 주세요 ")
    public ApiResponse<ReviewResponseDto.UserReviewListResult> getUserReviewList(
            @PathVariable Long userId,
            @ValidatedPage @RequestParam(defaultValue = "0") Integer page,
            @RequestParam(defaultValue = "10") Integer size) {
        Slice<Review> reviewList = reviewCommandService.findUserReviewList(userId, page, size);
        return ApiResponse.onSuccess(ReviewConverter.toUserReviewResultDto(reviewList));
    }

    @PostMapping("/")
    @Operation(summary = "사용자 리뷰 작성 API", description = "사용자가 특정 가게에 리뷰를 등록하는 API 입니다.")
    public ApiResponse<ReviewResponseDto.RegisterResultDto> postRegisterStore(
            @RequestBody @Valid ReviewRequestDto.RegisterDto request) {
        Review review = reviewCommandService.registerReview(request);
        return ApiResponse.onSuccess(ReviewConverter.toReviewRegisterResultDto(review));
    }

}
