package umc.presentation.controller.review;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import umc.application.service.review.ReviewCommandService;
import umc.common.ApiPayload.ApiResponse;
import umc.presentation.dto.ResponseEntityUtil;
import umc.presentation.dto.review.ReviewRequestDto;
import umc.presentation.dto.review.ReviewResponseDto;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/reviews")
public class ReviewRestController {
    private final ReviewCommandService reviewCommandService;

    @PostMapping("")
    public ResponseEntity<ApiResponse<?>> CreateReview(@RequestBody @Valid ReviewRequestDto.CreateReviewRequestDto requestDto) {
        return ResponseEntityUtil.buildResponseEntityWithStatus(
                ApiResponse.onSuccess( reviewCommandService.createReview(requestDto)), HttpStatus.CREATED);
    }
}
