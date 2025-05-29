package umc.study.web.dto.ReviewDTO;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import umc.study.validation.annotation.ExistStores;
import java.math.BigDecimal;
import java.util.List;

public class ReviewRequestDTO {
    @Getter
    public static class ReviewJoinDTO {
        @NotBlank
        String body;
        @NotNull
        BigDecimal score;
        @ExistStores
        Long storeId;
        List<String> reviewImageList;
    }

//    @Getter
//    @Setter
//    public static class ReviewImageDTO {
//        @NotBlank
//        String imageUrl;
//    }
}
