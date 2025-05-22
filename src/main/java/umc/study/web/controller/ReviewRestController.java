package umc.study.web.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import umc.study.apiPayload.ApiResponse;
import umc.study.converter.ReviewConverter;
import umc.study.domain.Review;
import umc.study.service.ReviewService.ReviewCommandService;
import umc.study.validation.annotation.ExistStores;
import umc.study.web.dto.ReviewRequestDTO;
import umc.study.web.dto.ReviewResponseDTO;

@Validated
@RestController
@RequiredArgsConstructor
public class ReviewRestController {
    private final ReviewCommandService reviewCommandService;

    @PostMapping("/api/v1/stores/{storeId}/reviews")
    public ApiResponse<ReviewResponseDTO.createResultDTO> createReview(
            @PathVariable @ExistStores Long storeId,
            @RequestBody @Valid ReviewRequestDTO.createReviewDto requestDto
    ) {
        Review review = reviewCommandService.save(storeId, requestDto);
        return ApiResponse.onSuccess(ReviewConverter.toReviewResponseDto(review));
    }
}
