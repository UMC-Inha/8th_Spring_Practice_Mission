package umc.study.web.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import umc.study.apiPayload.ApiResponse;
import umc.study.converter.ReviewConverter;
import umc.study.domain.Review;
import umc.study.service.ReviewService.ReviewQueryService;
import umc.study.web.dto.Review.ReviewRequestDto;
import umc.study.web.dto.Review.ReviewResponseDto;

@RestController
@RequiredArgsConstructor
@Validated
@RequestMapping("/reviews")
public class ReviewRestController {
    private final ReviewQueryService reviewQueryService;

    @PostMapping("")
    public ApiResponse<ReviewResponseDto.JoinResultDTO> join(@RequestBody @Valid ReviewRequestDto.JoinDto request){
        Review review = reviewQueryService.registerReview(request);
        return ApiResponse.onSuccess(ReviewConverter.toJoinResultDTO(review));
    }
}
