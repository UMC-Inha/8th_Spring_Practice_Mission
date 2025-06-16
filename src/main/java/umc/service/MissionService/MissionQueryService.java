package umc.service.MissionService;

import org.springframework.data.domain.Page;

import umc.domain.Mission;
import umc.domain.enums.MissionStatus;
import umc.domain.mapping.UserMission;

public interface MissionQueryService {

	Page<Mission> getRestaurantMissionList(Long restaurantId, Long userId, Integer page);

	Page<UserMission> getUserMissionList(Long userId, MissionStatus status, Integer page);
}
