package umc.UMC8th.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.time.LocalDateTime;


@Getter
@AllArgsConstructor
public class MemberMissionResponse {

    // 필요한 정보만 사용하도록 DTO 객체 구성
    private Long missionId;
    private String missionName;
    private String missionStatus;
    private Integer rewardPoints;
    private LocalDateTime completedDate;
}
