package umc.study.converter;

import umc.study.domain.store.FoodCategory;
import umc.study.domain.store.Region;
import umc.study.domain.store.Store;
import umc.study.domain.user.User;
import umc.study.web.dto.request.StoreRequestDto;
import umc.study.web.dto.response.StoreResponseDto;
import umc.study.web.dto.response.UserResponseDto;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;

public class StoreConverter {
    public static Store toStore(StoreRequestDto.RegisterDto request, Region region, FoodCategory category) {
        return Store.builder()
                .storeName(request.getName())
                .address(request.getAddress())
                .averageRate(BigDecimal.valueOf(0.0))
                .region(region)
                .category(category)
                .build();
    }

    public static StoreResponseDto.RegisterResultDto toStoreResponseDto(Store store) {
        return StoreResponseDto.RegisterResultDto.builder()
                .id(store.getId())
                .name(store.getStoreName())
                .address(store.getAddress())
                .createdAt(store.getCreatedAt())
                .build();
    }
}
