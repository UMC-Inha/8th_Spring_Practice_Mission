package umc.spring.web.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import umc.spring.apiPayload.ApiResponse;
import umc.spring.converter.ReviewConverter;
import umc.spring.domain.Review;
import umc.spring.service.reviewService.ReviewService;
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
}
