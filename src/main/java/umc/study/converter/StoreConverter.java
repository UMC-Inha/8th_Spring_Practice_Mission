package umc.study.converter;

import umc.study.domain.Store;
import umc.study.web.dto.StoreRequestDto;
import umc.study.web.dto.StoreResponseDto;

public class StoreConverter {
    public static Store toStore(StoreRequestDto request) {
        return Store.builder()
                .name(request.getName())
                .address(request.getAddress())
                .rating(request.getRating())
                .build();
    }

    public static StoreResponseDto toStoreResponseDTO(Store store) {
        return StoreResponseDto.builder()
                .id(store.getId())
                .name(store.getName())
                .address(store.getAddress())
                .regionName(store.getRegion().getName())
                .build();
    }
}