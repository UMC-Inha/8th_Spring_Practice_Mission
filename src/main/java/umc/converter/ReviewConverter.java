package umc.converter;

import umc.domain.Review;
import umc.dto.ReviewRequestDto;
import umc.dto.ReviewResponseDto;

public class ReviewConverter {

	public static ReviewResponseDto.JoinResultDto toJoinResultDTO(Review review){
		return ReviewResponseDto.JoinResultDto.builder()
			.reviewId(review.getId())
			.createdAt(review.getCreatedAt())
			.build();
	}

	public static Review toReview(ReviewRequestDto.JoinDto request){
		return Review.builder()
			.content(request.getContent())
			.score(request.getScore())
			.build();
	}
}
