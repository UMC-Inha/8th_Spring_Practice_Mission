package umc.study.web.converter.store;

import org.springframework.data.domain.Page;
import umc.study.domain.member.Member;
import umc.study.domain.review.Review;
import umc.study.domain.store.Store;
import umc.study.web.controller.store.dto.StoreReponseDTO;
import umc.study.web.controller.store.dto.StoreRequestDTO;

import java.util.List;

public class StoreConverter {
    public static StoreReponseDTO.addResultDto toAddResultDTO(Store store) {
        return StoreReponseDTO.addResultDto.builder()
                .storeId(store.getId())
                .storeName(store.getName())
                .address(store.getAddress())
                .score(store.getScore())
                .build();
    }


    public static Store toStore(StoreRequestDTO.AddDto request) {

        return Store.builder()
                .address(request.getAddress())
                .name(request.getStoreName())
                .score(request.getScore())
                .build();

    }

    public static Page<StoreReponseDTO.ReviewPreViewDTO> toReviewPreviewList(Page<Review> pageReview, Member member) {
        return pageReview
                .map(review -> StoreReponseDTO.ReviewPreViewDTO.builder()
                        .body(review.getBody())
                        .ownerNickname(member.getName())
                        .createdAt(review.getCreatedAt())
                        .score(review.getScore())
                        .build());
    }
}
