package umc.study.web.dto.Store;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import umc.study.web.dto.Review.ReviewResponseDto;

import java.time.LocalDateTime;
import java.util.List;

public class StoreResponseDto {
    @Builder
    @Getter
    @NoArgsConstructor
    @AllArgsConstructor
    public static class JoinResultDTO{
        Long storeId;
        Float score;
        String storeName;
        String region;
        String address;
        List<ReviewResponseDto.JoinResultDTO> reviewResponseDtoList;
        LocalDateTime createdAt;
    }
}
