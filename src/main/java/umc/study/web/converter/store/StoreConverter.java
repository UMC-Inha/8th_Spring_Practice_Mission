package umc.study.web.converter.store;

import umc.study.domain.store.Store;
import umc.study.web.controller.store.dto.StoreReponseDTO;
import umc.study.web.controller.store.dto.StoreRequestDTO;

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
}
