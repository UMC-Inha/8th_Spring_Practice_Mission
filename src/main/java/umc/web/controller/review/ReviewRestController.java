package umc.web.controller.review;

import io.swagger.v3.oas.annotations.Operation;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
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
}
