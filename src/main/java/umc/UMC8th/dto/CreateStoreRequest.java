package umc.UMC8th.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;

@Getter
public class CreateStoreRequest {

    @NotNull(message = "지역 ID는 필수입니다.")
    private Long regionId;

    @NotBlank(message = "가게 이름은 필수입니다.")
    private String storeName;

    @NotBlank(message = "가게 주소는 필수입니다.")
    private String storeAddress;
}
