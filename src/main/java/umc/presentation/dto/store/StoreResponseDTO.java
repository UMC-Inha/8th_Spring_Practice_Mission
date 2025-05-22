package umc.presentation.dto.store;

import lombok.Builder;

public class StoreResponseDTO {
    @Builder
    public record StoreLocationResultDto(
            Long storeId,
            String location){ }
}
