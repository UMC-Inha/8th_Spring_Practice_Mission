package umc.UMC8th.converter;

import umc.UMC8th.domain.Store;
import umc.UMC8th.dto.StoreResponse;

public class StoreConverter {

    public static StoreResponse toStoreResponse(Store store) {
        return StoreResponse.builder()
                .storeId(store.getId())
                .storeName(store.getName())
                .storeAddress(store.getAddress())
                .regionName(store.getRegion().getName())
                .build();
    }
}
