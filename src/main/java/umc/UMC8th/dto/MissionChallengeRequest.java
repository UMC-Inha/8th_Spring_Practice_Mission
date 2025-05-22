package umc.UMC8th.dto;

import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.NoArgsConstructor;
import umc.UMC8th.validation.annotation.NotDuplicatedMission;

@Getter
@NoArgsConstructor
public class MissionChallengeRequest {

    @NotNull(message = "missionId는 필수입니다.")
    @NotDuplicatedMission
    private Long missionId;
}
