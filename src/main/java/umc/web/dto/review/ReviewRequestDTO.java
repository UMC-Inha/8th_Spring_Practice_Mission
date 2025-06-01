package umc.web.dto.review;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

public class ReviewRequestDTO {

    @Getter
    public static class createReviewDTO{
        @NotBlank
        String content;

        @NotNull
        @Min(1)
        @Max(5)
        Integer stars;

        List<String> imageList = new ArrayList<>();
    }

}
