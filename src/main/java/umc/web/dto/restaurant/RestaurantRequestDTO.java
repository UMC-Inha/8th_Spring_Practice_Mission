package umc.web.dto.restaurant;

import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import umc.validation.annotation.ExistLocation;

import java.util.ArrayList;
import java.util.List;

public class RestaurantRequestDTO {

    @Getter
    public static class createRestaurantDTO{
        @NotBlank
        String name;
        String description;
        List<String> foodList = new ArrayList<>();
        List<String> imageList = new ArrayList<>();
    }



}
