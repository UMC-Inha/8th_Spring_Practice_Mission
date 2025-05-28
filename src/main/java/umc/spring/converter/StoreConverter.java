package umc.spring.converter;

import umc.spring.domain.FoodCategory;
import umc.spring.domain.Location;
import umc.spring.domain.Store;
import umc.spring.web.dto.store.StoreRequestDTO;
import umc.spring.web.dto.store.StoreResponseDTO;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class StoreConverter {

    public static StoreResponseDTO.CreateStoreResultDto toCreateStoreResultDto(Store store) {
        
        return StoreResponseDTO.CreateStoreResultDto.builder()
                .storeId(store.getId())
                .createdAt(LocalDateTime.now())
                .build();
    }

    public static Store toStore(StoreRequestDTO.CreateStoreDto request, Location location, FoodCategory foodCategory) {
        return Store.builder()
                .name(request.getName())
                .address(request.getAddress())
                .score(BigDecimal.valueOf(0.0))
                .location(location)
                .foodCategory(foodCategory)
                .build();
    }
}

