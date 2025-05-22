package umc.study.web.dto;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Builder
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class MissionRequestDto {
    @NotNull
    Long missionId;
    @NotNull
    Long userId;
    @NotNull
    Integer missionPrice;
    @NotNull
    String content;
    @NotNull
    Integer point;
    @NotNull
    LocalDateTime doneAt;
    private Long storeId;
    private String missionSpec;
    private LocalDate deadline;
}
