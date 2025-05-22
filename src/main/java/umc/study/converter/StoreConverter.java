package umc.study.converter;

import umc.study.domain.Region;
import umc.study.domain.Store;
import umc.study.web.dto.StoreDTO.StoreRequestDTO;
import umc.study.web.dto.StoreDTO.StoreResponseDTO;
import java.time.LocalDateTime;

public class StoreConverter {
    public static StoreResponseDTO.StoreJoinResultDTO toStoreJoinResultDTO(Store store) {
        return StoreResponseDTO.StoreJoinResultDTO.builder()
                .storeId(store.getId())
                .createdAt(LocalDateTime.now())
                .build();
    }

    public static Store toStore(StoreRequestDTO.StoreJoinDTO request, Region region) {
        return Store.builder()
                .name(request.getName())
                .address(request.getAddress())
                .region(region)
                .build();
    }
}
