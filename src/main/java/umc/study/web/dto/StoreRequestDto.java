package umc.study.web.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import umc.study.validation.annotation.ExistCategories;
import lombok.Getter;

import java.math.BigDecimal;
import java.util.List;

@Getter
public class StoreRequestDto {
    @NotBlank
    private String name;

    @NotBlank
    private String address;

    @NotNull
    private Long regionId;

    @NotNull
    private BigDecimal rating;

    @ExistCategories
    private List<Long> foodCategoryId;
}

