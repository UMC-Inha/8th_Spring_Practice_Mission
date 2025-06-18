package umc.study.web.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import umc.study.apiPayload.ApiResponse;
import umc.study.converter.ReviewConverter;
import umc.study.domain.Review;
import umc.study.resolver.PageParam;
import umc.study.service.ReviewService.ReviewCommandService;
import umc.study.service.ReviewService.ReviewQueryService;
import umc.study.validation.annotation.ExistMember;
import umc.study.validation.annotation.ExistStores;
import umc.study.web.dto.request.ReviewRequestDTO;
import umc.study.web.dto.response.ReviewResponseDTO;

@Validated
@RestController
@RequiredArgsConstructor
@Tag(name = "리뷰 API")
public class ReviewRestController {
    private final ReviewCommandService reviewCommandService;
    private final ReviewQueryService reviewQueryService;

    @PostMapping("/api/v1/stores/{storeId}/reviews")
    public ApiResponse<ReviewResponseDTO.createResultDTO> createReview(
            @PathVariable @ExistStores Long storeId,
            @RequestBody @Valid ReviewRequestDTO.createReviewDto requestDto
    ) {
        Review review = reviewCommandService.save(storeId, requestDto);
        return ApiResponse.onSuccess(ReviewConverter.toReviewResponseDto(review));
    }

    @Operation(summary = "내가 작성한 리뷰 목록", description = "로그인한 사용자가 작성한 리뷰를 조회합니다.")
    @GetMapping("/api/v1/reviews/me")
    // TODO: 사용자 인증 토큰에서 추출한 사용자 정보 바탕으로 API 구성하기
    public ApiResponse<ReviewResponseDTO.ReviewPreViewListDTO<ReviewResponseDTO.MyReviewPreViewDTO>> getMyReviews(@PageParam Integer page, @RequestParam @ExistMember Long userId) {
        Page<Review> reviewList = reviewQueryService.getMyReviewList(page, userId);
        return ApiResponse.onSuccess(ReviewConverter.toReviewPreViewListDTO(reviewList, ReviewConverter::toMyReviewPreViewDTO));
    }
}
