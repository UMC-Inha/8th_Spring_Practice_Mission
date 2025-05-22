package umc.UMC8th.dto;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.NoArgsConstructor;
import umc.UMC8th.validation.annotation.ExistStore;

import java.time.LocalDate;

@Getter
@NoArgsConstructor
public class CreateMissionRequest {

    @ExistStore  // 존재하는 가게인지 검증
    @NotNull(message = "storeId는 필수입니다.")
    private Long storeId;

    @NotBlank(message = "미션 제목은 필수입니다.")
    private String title;

    @NotBlank(message = "미션 설명은 필수입니다.")
    private String explanation;

    @NotNull(message = "보상 포인트는 필수입니다.")
    @Min(value = 1, message = "최소 포인트는 1포인트 이상입니다.")
    private Integer rewardPoints;

    @NotBlank(message = "인증 번호는 필수입니다.")
    private String completedNumber;

    @NotNull(message = "마감 기한은 필수입니다.")
    private LocalDate deadline;
}
