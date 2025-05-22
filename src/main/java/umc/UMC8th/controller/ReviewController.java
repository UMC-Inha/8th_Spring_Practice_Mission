package umc.UMC8th.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import umc.UMC8th.apiPayload.ApiResponse;
import umc.UMC8th.converter.ReviewConverter;
import umc.UMC8th.domain.Review;
import umc.UMC8th.dto.CreateReviewRequest;
import umc.UMC8th.dto.CreateReviewResponse;
import umc.UMC8th.service.ReviewCommandService;

@RestController
@RequiredArgsConstructor
@RequestMapping("/reviews")
public class ReviewController {

    private final ReviewCommandService reviewCommandService;

    @PostMapping
    public ApiResponse<CreateReviewResponse> createReview(
            @RequestBody @Valid CreateReviewRequest request) {

        Review savedReview = reviewCommandService.createReview(request);
        return ApiResponse.onSuccess(ReviewConverter.toReviewResponse(savedReview));
    }
}
