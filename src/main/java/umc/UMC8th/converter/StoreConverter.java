package umc.UMC8th.converter;

import org.springframework.data.domain.Page;
import umc.UMC8th.domain.Review;
import umc.UMC8th.domain.Store;
import umc.UMC8th.dto.StoreResponse;
import umc.UMC8th.dto.StoreResponseDTO;

import java.util.List;
import java.util.stream.Collectors;

public class StoreConverter {

    public static StoreResponse toStoreResponse(Store store) {
        return StoreResponse.builder()
                .storeId(store.getId())
                .storeName(store.getName())
                .storeAddress(store.getAddress())
                .regionName(store.getRegion().getName())
                .build();
    }

    public static StoreResponseDTO.ReviewPreViewDTO reviewPreViewDTO(Review review) {
        return StoreResponseDTO.ReviewPreViewDTO.builder()
                .ownerNickname(review.getMember().getName()) // 닉네임(객체 그래프 탐색)
                .score(review.getRating().floatValue()) // 별점
                .body(review.getReviewText()) // 리뷰 내용
                .createdAt(review.getCreatedAt().toLocalDate()) // 작성일
                .build();
    }

    // 페이징 기능을 사용하기 위해 List<Review> -> Page<Review>로 변경
    public static StoreResponseDTO.ReviewPreViewListDTO reviewPreViewListDTO(Page<Review> reviewPage) {
        List<StoreResponseDTO.ReviewPreViewDTO> dtoList = reviewPage.getContent().stream()
                .map(StoreConverter::reviewPreViewDTO)
                .collect(Collectors.toList());

        return StoreResponseDTO.ReviewPreViewListDTO.builder()
                .reviewList(dtoList)  // 변환된 리뷰 DTO 리스트
                .listSize(dtoList.size()) // 현재 페이지 리뷰 개수
                .totalPage(reviewPage.getTotalPages()) // 전체 페이지 수
                .totalElements(reviewPage.getTotalElements()) // 전체 요소 개수
                .isFirst(reviewPage.isFirst())  // 현재 페이지가 첫 페이지인지 여부
                .isLast(reviewPage.isLast())   // 현재 페이지가 마지막 페이지인지 여부
                .build();
    }
}
