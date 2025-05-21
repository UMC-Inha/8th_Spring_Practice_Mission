package umc.study.web.controller.review.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.URL;
import org.jspecify.annotations.Nullable;
import umc.study.repository.store.StoreRepository;
import umc.study.validation.annotation.ExistsInDb;

import java.math.BigDecimal;
import java.util.List;

public class ReviewRequestDTO {

    @Getter
    @AllArgsConstructor
    @NoArgsConstructor
    @Builder
    public static class AddDto {
        @ExistsInDb(
                message = "해당 가게가 존재하지 않습니다.",
                repository = StoreRepository.class
        )
        private Long storeId;

        @NotBlank
        private String comment;

        @NotBlank
        private BigDecimal score;

        @Size(max = 3, message = "이미지는 최대 3장까지 업로드할 수 있습니다.")
        private List<@NotBlank @URL String> imageList; //이미지 안 넣어도 됨, 근데 넣었을 경우 "" 빈 문자열 방지
    }

}
