package umc.application.service.mission;

import org.springframework.data.domain.Page;
import umc.infrastructure.persistence.entity.mission.Mission;
import umc.infrastructure.persistence.entity.mission.MissionState;

public interface MissionQueryService {
    Page<Mission> getMissionsByStoreId(Long storeId, Integer page);

    Page<Mission> getMissionsByUserId(Long userId,  MissionState missionState, Integer page);

}
