/*package umc.study.web.dto;

import com.querydsl.core.annotations.QueryProjection;
import lombok.AllArgsConstructor;
import lombok.Data;
import umc.study.domain.enums.MissionStatus;

@Data
public class MissionDto {
    private Long missionId;
    private String missionSpec;
    private String storeName;
    private int point;
    private MissionStatus status;

    @QueryProjection
    public MissionDto(Long missionId, String missionSpec, String storeName, int point, MissionStatus status) {
        this.missionId = missionId;
        this.missionSpec = missionSpec;
        this.storeName = storeName;
        this.point = point;
        this.status = status;
    }
}*/
