package umc.web.controller.review;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.Parameters;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;
import umc.apiPayload.ApiResponse;
import umc.converter.review.ReviewConverter;
import umc.domain.Review;
import umc.dto.review.ReviewRequestDTO;
import umc.dto.review.ReviewResponseDTO;
import umc.service.review.ReviewService;

@RestController
@RequiredArgsConstructor
@RequestMapping("/")
public class ReviewRestController {

    private final ReviewService reviewService;

    @PostMapping("/restaurants/{restaurantId}/reviews")
    @Operation(summary = "리뷰 작성 API")
    public ApiResponse<ReviewResponseDTO.WriteReviewResultDto> write(@RequestBody @Valid ReviewRequestDTO.WriteReviewDto request, @RequestParam("restaurantId") Long restaurantId) {
        Review newReview = reviewService.writeReview(request, restaurantId);
        return ApiResponse.onSuccess(ReviewConverter.toWriteReviewResultDto(newReview));
    }

    @GetMapping("/restaurants/{restaurantId}/reviews")
    @Operation(summary = "특정 가게의 리뷰 목록 조회 API")
    @Parameters({
            @Parameter(name = "restaurantId", description = "가게의 아이디, path variable 입니다!")
    })
    public ApiResponse<ReviewResponseDTO.PreviewReviewListResultDto> getReviewList(@PathVariable(name = "restaurantId") Long restaurantId,
                                                                                   @RequestParam(name = "page") Integer page) {
        Page<Review> reviewPage = reviewService.getReviewList(restaurantId, page  - 1);
        return ApiResponse.onSuccess(ReviewConverter.previewReviewListResultDto(reviewPage));
    }

    @GetMapping("/mypage/reviews")
    @Operation(summary = "내가 작성한 리뷰 목록 조회 API")
    public ApiResponse<ReviewResponseDTO.PreviewMyReviewListResultDto> getMyReviewList(@RequestParam(name = "memberId") Long memberId,
                                                                                       @RequestParam(name = "page") Integer page) {
        Page<Review> reviewPage = reviewService.getReviewListByMember(memberId, page  - 1);
        return ApiResponse.onSuccess(ReviewConverter.previewMyReviewListResultDto(reviewPage));
    }
}
