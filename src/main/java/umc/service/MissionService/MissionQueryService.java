package umc.service.MissionService;

import org.springframework.data.domain.Page;

import umc.domain.Mission;

public interface MissionQueryService {

	Page<Mission> getRestaurantMissionList(Long restaurantId, Long userId, Integer page);
}
