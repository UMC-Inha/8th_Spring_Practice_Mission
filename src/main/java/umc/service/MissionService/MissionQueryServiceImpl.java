package umc.service.MissionService;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import lombok.RequiredArgsConstructor;
import umc.domain.Mission;
import umc.repository.MissionRepository.MissionRepository;

@Service
@RequiredArgsConstructor
public class MissionQueryServiceImpl implements MissionQueryService {

	private final MissionRepository missionRepository;

	@Override
	@Transactional(readOnly = true)
	public Page<Mission> getRestaurantMissionList(Long restaurantId, Long userId, Integer page) {
		return missionRepository.findAllNotInUserMission(restaurantId, userId, PageRequest.of(page, 10));
	}
}
