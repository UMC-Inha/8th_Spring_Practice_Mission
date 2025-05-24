package umc.study.web.dto.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;
import umc.study.validation.annotation.ExistCategories;

import java.math.BigDecimal;

public class StoreRequestDto {

    @Getter
    @Setter
    public static class RegisterDto{
        @NotBlank(message = "이름은 필수입니다.")
        private String name;

        @NotBlank(message = "주소는 필수입니다.")
        private String address;

        @ExistCategories
        private Long foodCategoryId;

        @NotBlank(message = "지역은 필수입니다.")
        private Long regionId;
    }
}
