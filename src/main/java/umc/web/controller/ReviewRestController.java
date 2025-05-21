package umc.web.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import umc.apiPayload.ApiResponse;
import umc.service.review.ReviewCommandService;
import umc.validation.annotation.ExistLocation;
import umc.web.dto.review.ReviewRequestDTO;

@RestController
@RequiredArgsConstructor
@RequestMapping("/reviews")
@Validated
public class ReviewRestController {

    private final ReviewCommandService reviewCommandService;

    @PostMapping("/{restaurantId}/reviews")
    public ApiResponse<String> createReview(
            @RequestBody @Valid ReviewRequestDTO.createReviewDTO request, @ExistLocation @PathVariable Long restaurantId) {

        reviewCommandService.createReview(request, restaurantId);
        return ApiResponse.onSuccess("리뷰가 등록되었습니다");

    }



}
