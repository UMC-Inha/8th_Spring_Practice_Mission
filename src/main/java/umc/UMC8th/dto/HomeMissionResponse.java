package umc.UMC8th.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class HomeMissionResponse {
    private Long missionId;
    private String missionName;
    private Integer rewardPoints;
    private LocalDateTime missionDeadline;
    private String storeName;
    private String storeAddress;
    private Integer userPoints;
    private String regionName;
}
