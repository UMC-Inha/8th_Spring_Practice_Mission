package umc.study.web.controller.store.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

public class StoreReponseDTO {

    @Builder
    @Getter
    @NoArgsConstructor
    @AllArgsConstructor
    public static class addResultDto {
        private Long storeId;

        private String storeName;

        private String address;

        private BigDecimal score;
    }
}
