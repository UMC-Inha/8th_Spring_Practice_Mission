package umc.dto.restaurant;

import jakarta.validation.constraints.NotNull;
import lombok.Getter;

import java.awt.*;
import java.util.List;


public class RestaurantRequestDTO {

    @Getter
    public static class CreateRestaurantDto {
        @NotNull
        String name;
        @NotNull
        String address;
        @NotNull
        Point mapLocation;
        @NotNull
        Long locationId;
        @NotNull
        Long foodCategory;
    }
}
