package umc.presentation.dto.store;

import umc.common.validation.annotation.ExistStore;

public class StoreRequestDTO {

    public record StoreLocationDTO(
            @ExistStore Long storeId,
            String location){}

    public record StoreCreateDto(String storeName,
                                 String location,
                                 String storeInfo,
                                 String address){}
}


