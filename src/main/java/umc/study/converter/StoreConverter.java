package umc.study.converter;

import umc.study.domain.Region;
import umc.study.domain.Store;
import umc.study.web.dto.Review.ReviewResponseDto;
import umc.study.web.dto.Store.StoreRequestDto;
import umc.study.web.dto.Store.StoreResponseDto;

import java.util.ArrayList;
import java.util.List;

public class StoreConverter {

    public static StoreResponseDto.JoinResultDTO toJoinResultDTO(Store store){

        List<ReviewResponseDto.JoinResultDTO> reviewResponseDtoList = store.getReviewList()
                .stream().map(ReviewConverter::toJoinResultDTO).toList();

        return StoreResponseDto.JoinResultDTO.builder()
                .storeId(store.getId())
                .storeName(store.getName())
                .region(store.getRegion().getName())
                .score(store.getScore())
                .reviewResponseDtoList(reviewResponseDtoList)
                .createdAt(store.getCreatedAt())
                .build();
    }

    public static Store toStore(StoreRequestDto.JoinDto request){

        Region region = RegionConverter.toRegion(request.getRegion());

        return Store.builder()
                .name(request.getName())
                .address(request.getAddress())
                .region(region)
                .reviewList(new ArrayList<>())
                .build();
    }
}
