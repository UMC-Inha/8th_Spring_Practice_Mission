package umc.study.web.controller.review.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.URL;

import java.math.BigDecimal;
import java.util.List;


public class ReviewResponseDTO {

    @Builder
    @Getter
    @NoArgsConstructor
    @AllArgsConstructor
    public static class addResultDto{
        private Long reviewId;
        private String comment;
        private BigDecimal score;

        @Size
        private List<@NotBlank @URL String> imageList;
    }
    @Builder
    @Getter
    @NoArgsConstructor
    @AllArgsConstructor
    public static class getReviewListResultDto{
        private Long reviewId;
        private String comment;
        private BigDecimal score;
    }



}
