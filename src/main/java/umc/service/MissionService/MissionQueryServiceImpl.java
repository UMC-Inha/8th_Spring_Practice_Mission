package umc.service.MissionService;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import lombok.RequiredArgsConstructor;
import umc.apiPayload.code.status.ErrorStatus;
import umc.apiPayload.exception.GeneralException;
import umc.domain.Mission;
import umc.domain.User;
import umc.domain.enums.MissionStatus;
import umc.domain.mapping.UserMission;
import umc.repository.MissionRepository.MissionRepository;
import umc.repository.UserMissionRepository.UserMissionRepository;
import umc.repository.UserRepository.UserRepository;

@Service
@RequiredArgsConstructor
public class MissionQueryServiceImpl implements MissionQueryService {

	private final MissionRepository missionRepository;
	private final UserRepository userRepository;
	private final UserMissionRepository userMissionRepository;

	@Override
	@Transactional(readOnly = true)
	public Page<Mission> getRestaurantMissionList(Long restaurantId, Long userId, Integer page) {
		return missionRepository.findAllNotInUserMission(restaurantId, userId, PageRequest.of(page, 10));
	}

	@Override
	@Transactional(readOnly = true)
	public Page<UserMission> getUserMissionList(Long userId, MissionStatus status, Integer page) {
		User user = userRepository.findById(userId).orElseThrow(
			() -> new GeneralException(ErrorStatus.USER_NOT_FOUND));

		return userMissionRepository.findAllByUserAndStatus(user, status, PageRequest.of(page, 10));
	}
}
