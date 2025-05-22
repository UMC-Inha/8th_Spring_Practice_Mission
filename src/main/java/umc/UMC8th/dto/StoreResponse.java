package umc.UMC8th.dto;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class StoreResponse {
    private Long storeId;
    private String storeName;
    private String storeAddress;
    private String regionName;
}
