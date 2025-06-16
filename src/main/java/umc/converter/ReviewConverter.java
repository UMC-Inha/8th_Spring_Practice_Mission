package umc.converter;

import java.util.List;

import org.springframework.data.domain.Page;

import umc.domain.Reply;
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


	public static ReviewResponseDto.ReviewListDto toReviewListDto(Page<Review> reviewList){

		List<ReviewResponseDto.ReviewDto> reviewDtoList = reviewList.stream()
			.map(review -> toReviewDto(review))
			.toList();

		return ReviewResponseDto.ReviewListDto.builder()
			.isLast(reviewList.isLast())
			.isFirst(reviewList.isFirst())
			.totalPage(reviewList.getTotalPages())
			.totalElements(reviewList.getTotalElements())
			.listSize(reviewDtoList.size())
			.reviewList(reviewDtoList)
			.build();
	}

	public static ReviewResponseDto.ReviewDto toReviewDto(Review review){

		return ReviewResponseDto.ReviewDto.builder()
			.writer(review.getUser().getName())
			.score(review.getScore())
			.content(review.getContent())
			.createdAt(review.getCreatedAt())
			.reply(review.getReply() != null ? toReplyDto(review.getReply()) : null)
			.build();
	}

	public static ReviewResponseDto.ReplyDto toReplyDto(Reply reply){

		return ReviewResponseDto.ReplyDto.builder()
			.content(reply.getContent())
			.createdAt(reply.getCreatedAt())
			.build();
	}
}
