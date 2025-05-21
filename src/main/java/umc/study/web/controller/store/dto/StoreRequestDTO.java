package umc.study.web.controller.store.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.URL;
import umc.study.repository.mission.MissionRepository;
import umc.study.repository.region.RegionRepository;
import umc.study.validation.annotation.ExistsInDb;

import java.math.BigDecimal;
import java.util.List;

public class StoreRequestDTO {
    @Getter
    @AllArgsConstructor
    @NoArgsConstructor
    @Builder
    public static class AddDto {
        @ExistsInDb(
                message = "해당 지역이 존재하지 않습니다.",
                repository = RegionRepository.class
        )
        private Long regionId;

        @NotBlank
        private String storeName;

        @NotBlank
        private String address;

        private BigDecimal score = BigDecimal.valueOf(0.0); //가게 등록할 때는 score 0으로 설정

        @Size(max = 1, message = "이미지는 1장만 등록할 수 있습니다.")
        private List<@NotBlank @URL String> imageList; //이미지 안 넣어도 됨, 근데 넣었을 경우 "" 빈 문자열 방지
    }


}
