package umc.spring.converter;

import org.springframework.data.domain.Page;
import umc.spring.domain.FoodCategory;
import umc.spring.domain.Location;
import umc.spring.domain.Review;
import umc.spring.domain.Store;
import umc.spring.web.dto.review.ReviewResponseDTO;
import umc.spring.web.dto.store.StoreRequestDTO;
import umc.spring.web.dto.store.StoreResponseDTO;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

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

