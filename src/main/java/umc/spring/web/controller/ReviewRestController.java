package umc.spring.web.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.Parameters;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;
import umc.spring.apiPayload.ApiResponse;
import umc.spring.converter.ReviewConverter;
import umc.spring.domain.Review;
import umc.spring.service.reviewService.ReviewService;
import umc.spring.validation.annotation.ExistStores;
import umc.spring.web.dto.review.ReviewRequestDTO;
import umc.spring.web.dto.review.ReviewResponseDTO;

@RestController
@RequiredArgsConstructor
@RequestMapping("/")
public class ReviewRestController {

    private final ReviewService reviewService;

    @PostMapping("/stores/{storeId}/reviews")
    public ApiResponse<ReviewResponseDTO.CreateReviewResultDTO> write(@RequestBody @Valid ReviewRequestDTO.CreateReviewDTO request, @PathVariable("storeId") Long storeId){
        Review newReview = reviewService.writeReview(request, storeId);
        return ApiResponse.onSuccess(ReviewConverter.toWriteReviewResultDto(newReview));
    }

    @GetMapping("/reviews/mypage")
    @Operation(summary = "내가 작성한 리뷰 목록")
    public ApiResponse<ReviewResponseDTO.PreviewMyReviewListResultDto> getReviewList(@RequestParam(name = "memberId") Long memberId, @RequestParam(name = "page") Integer page) {
        Page<Review> reviewList = reviewService.getReviewList(memberId, page);
        return ApiResponse.onSuccess(ReviewConverter.previewMyReviewListResultDto(reviewList));
    }
}
