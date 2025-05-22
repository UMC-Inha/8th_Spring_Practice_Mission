package umc.study.web.dto.StoreDTO;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;

public class StoreRequestDTO {
    @Getter
    public static class StoreJoinDTO {
        @NotBlank
        String name;
        @NotBlank
        String address;
        @NotNull
        Long regionId;
    }
}
