package umc.presentation.dto.store;

import lombok.Setter;
import umc.common.validation.annotation.ExistStore;

public class StoreRequestDTO {

    public record StoreLocationDTO(
            @ExistStore Long storeId,
            String location){}
}
