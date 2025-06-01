package umc.service.mission;

import org.springframework.data.domain.Page;
import umc.domain.Mission;
import umc.domain.mapping.UserMission;

public interface MissionQueryService {

    Page<Mission> getMissionListByRestaurantId(Long restaurantId, Integer page);

    Page<UserMission> getMissionListByUserId(Long userId, Integer page);
}
