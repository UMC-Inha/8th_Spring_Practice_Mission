package umc.study.converter;

import org.springframework.data.domain.Page;
import umc.study.domain.Review;
import umc.study.domain.ReviewPicture;
import umc.study.domain.Store;
import umc.study.web.dto.request.ReviewRequestDTO;
import umc.study.web.dto.response.ReviewResponseDTO;

import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

public class ReviewConverter {
    public static Review toReview(Store store, ReviewRequestDTO.createReviewDto dto) {
        return Review.builder()
                .score(dto.getScore())
                .body(dto.getBody())
                .store(store)
                .build();
    }

    public static List<ReviewPicture> toReviewPictures(List<String> urls, Review review) {
        return urls.stream()
                .map(url -> ReviewPicture.builder()
                        .review(review)
                        .url(url)
                        .build())
                .collect(Collectors.toList());
    }

    public static ReviewResponseDTO.createResultDTO toReviewResponseDto(Review review) {
        return ReviewResponseDTO.createResultDTO.builder()
                .reviewId(review.getId())
                .createdAt(review.getCreatedAt())
                .build();
    }

    public static ReviewResponseDTO.ReviewPreViewDTO toReviewPreViewDTO(Review review) {
        return ReviewResponseDTO.ReviewPreViewDTO.builder()
                .ownerNickname(review.getMember().getName())
                .score(review.getScore())
                .createdAt(review.getCreatedAt().toLocalDate())
                .body(review.getBody())
                .build();
    }


    public static ReviewResponseDTO.MyReviewPreViewDTO toMyReviewPreViewDTO(Review review) {
        return ReviewResponseDTO.MyReviewPreViewDTO.builder()
                .ownerNickname(review.getMember().getName())
                .storeName(review.getStore().getName())
                .score(review.getScore())
                .createdAt(review.getCreatedAt().toLocalDate())
                .body(review.getBody())
                .build();
    }

    public static <T> ReviewResponseDTO.ReviewPreViewListDTO<T> toReviewPreViewListDTO
            (Page<Review> reviewPage, Function<Review, T> mappingFunction) {
        //Function<T,R>: T 받아서 R 반환 (Java의 타입 추론으로 함수 자동 매핑됨, 만약 함수가 모호하면 컴파일 오류가 남)

        List<T> dtoList = reviewPage.stream()
                .map(mappingFunction)
                .collect(Collectors.toList());

        return ReviewResponseDTO.ReviewPreViewListDTO.<T>builder()
                .reviewList(dtoList)
                .listSize(dtoList.size())
                .totalPage(reviewPage.getTotalPages())
                .totalElements(reviewPage.getTotalElements())
                .isFirst(reviewPage.isFirst())
                .isLast(reviewPage.isLast())
                .build();
    }
}
