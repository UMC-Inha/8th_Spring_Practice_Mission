package umc.study.web.dto.Store;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Getter;

public class StoreRequestDto {
    @Getter
    public static class JoinDto{
        @NotBlank
        String name;

        @Size(min = 5, max = 50)
        String region;

        @Size(min = 5, max = 50)
        String address;
    }
}
