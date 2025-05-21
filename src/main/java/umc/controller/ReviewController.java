package umc.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import umc.apiPayload.ApiResponse;
import umc.converter.ReviewConverter;
import umc.domain.Review;
import umc.dto.ReviewRequestDto;
import umc.dto.ReviewResponseDto;
import umc.dto.UserRequestDto;
import umc.dto.UserResponseDto;
import umc.service.ReviewService.ReviewCommandService;

@RestController
@RequiredArgsConstructor
@RequestMapping("/reviews")
public class ReviewController {

	private final ReviewCommandService reviewCommandService;

	@PostMapping
	public ResponseEntity<ApiResponse<ReviewResponseDto.JoinResultDto>> join(@RequestBody @Valid ReviewRequestDto.JoinDto request) {
		Review review = reviewCommandService.joinReview(request);
		return ResponseEntity.ok(ApiResponse.onSuccess(ReviewConverter.toJoinResultDTO(review)));
	}
}
