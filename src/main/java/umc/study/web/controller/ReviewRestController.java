package umc.study.web.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
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

    @GetMapping("/{memberId}")
    public ApiResponse<Page<ReviewResponseDto.JoinResultDTO>> getUserReviews(
            @PageableDefault(size = 10, sort = "createdAt", direction = Sort.Direction.DESC)
            Pageable pageable,
            @PathVariable("memberId") Long memberId
    ) {
        return ApiResponse.onSuccess(reviewQueryService.findUserReviews(memberId, pageable));
    }

    @PostMapping("")
    public ApiResponse<ReviewResponseDto.JoinResultDTO> join(@RequestBody @Valid ReviewRequestDto.JoinDto request){
        Review review = reviewQueryService.registerReview(request);
        return ApiResponse.onSuccess(ReviewConverter.toJoinResultDTO(review));
    }
}
