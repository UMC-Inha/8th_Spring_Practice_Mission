package umc.study.web.dto.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;
import umc.study.validation.annotation.ExistStore;

import java.time.LocalDateTime;

public class MissionRequestDto {

    @Getter
    @Setter
    public static class RegisterDto {

        @NotNull
        @ExistStore
        private Long storeId;

        @NotBlank(message = "미션 제목은 필수입니다.")
        private String title;

        @NotBlank(message = "미션 내용은 필수입니다.")
        private String missionContent;

        @NotNull(message = "포인트는 필수입니다.")
        private Integer rewardPoint;

        @NotNull(message = "종료일자는 필수입니다.")
        private LocalDateTime endDate;
    }
}
