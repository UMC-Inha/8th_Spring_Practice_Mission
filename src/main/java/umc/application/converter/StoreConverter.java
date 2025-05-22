package umc.application.converter;

import umc.infrastructure.persistence.entity.store.Store;
import umc.presentation.dto.store.StoreResponseDTO;

public class StoreConverter {
    public static StoreResponseDTO.StoreLocationResultDto toStoreLocationResultDto(Store store){
        return StoreResponseDTO.StoreLocationResultDto.builder()
                .storeId(store.getId())
                .location(store.getLocation())
                .build();
    }
}

/*
*             String storeId,
            String location,
            String address,
            String storeName,
            String storeType,
            String storePhoneNumber,
            String storeImageUrl){}
}
* */