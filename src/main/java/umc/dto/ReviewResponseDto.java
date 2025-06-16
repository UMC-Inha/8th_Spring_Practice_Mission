package umc.dto;

import java.time.LocalDateTime;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

public class ReviewResponseDto {

	@Builder
	@Getter
	@AllArgsConstructor
	public static class JoinResultDto{
		Long reviewId;
		LocalDateTime createdAt;
	}

	@Builder
	@Getter
	@AllArgsConstructor
	public static class ReviewListDto {
		List<ReviewDto> reviewList;
		Integer listSize;
		Integer totalPage;
		Long totalElements;
		Boolean isFirst;
		Boolean isLast;
	}

	@Builder
	@Getter
	@AllArgsConstructor
	public static class ReviewDto {
		String writer;
		Integer score;
		String content;
		LocalDateTime createdAt;
		ReplyDto reply;
	}

	@Builder
	@Getter
	@AllArgsConstructor
	public static class ReplyDto {
		String content;
		LocalDateTime createdAt;
	}
}
