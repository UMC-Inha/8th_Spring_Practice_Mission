package umc.study.web.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import umc.study.apiPayload.ApiResponse;
import umc.study.converter.ReviewConverter;
import umc.study.domain.review.Review;
import umc.study.service.review.ReviewCommandService;
import umc.study.web.dto.request.ReviewRequestDto;
import umc.study.web.dto.response.ReviewResponseDto;

@RestController
@RequiredArgsConstructor
@RequestMapping("/reviews")
public class ReviewRestController {

    private final ReviewCommandService reviewCommandService;

    @PostMapping("/")
    public ApiResponse<ReviewResponseDto.RegisterResultDto> registerStore(
            @RequestBody @Valid ReviewRequestDto.RegisterDto request) {
        Review review = reviewCommandService.registerReview(request);
        return ApiResponse.onSuccess(ReviewConverter.toReviewRegisterResultDto(review));
    }
}
