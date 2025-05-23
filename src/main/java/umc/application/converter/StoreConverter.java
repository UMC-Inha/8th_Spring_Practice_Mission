package umc.application.converter;

import umc.infrastructure.persistence.entity.store.Store;
import umc.presentation.dto.store.StoreRequestDTO;
import umc.presentation.dto.store.StoreResponseDTO;

public class StoreConverter {

    public static Store toStore(StoreRequestDTO.StoreCreateDto request){
        return Store.builder()
                .location(request.location())
                .storeName(request.storeName())
                .storeInfo(request.storeInfo())
                .address(request.address())
                .build();
    }
    public static StoreResponseDTO.StoreCreateResultDto toStoreCreateResultDto(Store store){
        return StoreResponseDTO.StoreCreateResultDto.builder().storeId(store.getId()).build();
    }
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