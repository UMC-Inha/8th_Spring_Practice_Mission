package umc.spring.web.dto.store;

import jakarta.validation.constraints.NotNull;
import lombok.Getter;

import java.awt.*;

public class StoreRequestDTO {

    @Getter
    public static class CreateStoreDto {
        @NotNull
        String name;
        @NotNull
        String address;
        @NotNull
        Long locationId;
        @NotNull
        Long foodCategory;
    }
}