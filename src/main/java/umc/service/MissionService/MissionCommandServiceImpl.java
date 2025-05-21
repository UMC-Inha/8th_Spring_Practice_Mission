package umc.service.MissionService;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import lombok.RequiredArgsConstructor;
import umc.apiPayload.code.status.ErrorStatus;
import umc.apiPayload.exception.GeneralException;
import umc.converter.MissionConverter;
import umc.domain.Mission;
import umc.domain.Restaurant;
import umc.domain.User;
import umc.domain.mapping.UserMission;
import umc.dto.MissionRequestDto;
import umc.repository.MissionRepository.MissionRepository;
import umc.repository.RestaurantRepository.RestaurantRepository;
import umc.repository.UserMissionRepository.UserMissionRepository;
import umc.repository.UserRepository.UserRepository;

@Service
@RequiredArgsConstructor
public class MissionCommandServiceImpl implements MissionCommandService {

	private final UserMissionRepository userMissionRepository;
	private final UserRepository userRepository;
	private final MissionRepository missionRepository;
	private final RestaurantRepository restaurantRepository;

	@Override
	@Transactional
	public Mission joinMission(MissionRequestDto.JoinMissionDto request) {
		Mission newMission = MissionConverter.toMission(request);
		Restaurant restaurant = restaurantRepository.findById((request.getRestaurantId())).orElseThrow(() -> new GeneralException(
			ErrorStatus.RESTAURANT_NOT_FOUND));

		// 연관 관계 설정
		newMission.setRestaurant(restaurant);
		newMission.setRegion(restaurant.getRegion());

		return missionRepository.save(newMission);
	}

	@Override
	@Transactional
	public UserMission challengeMission(MissionRequestDto.ChallengeDto request) {
		UserMission newUserMission = MissionConverter.toUserMission(request);
		User user = userRepository.findByEmail(request.getUserEmail()).orElseThrow(() -> new GeneralException(ErrorStatus.USER_NOT_FOUND));
		Mission mission = missionRepository.findById(request.getMissionId()).orElseThrow(() -> new GeneralException(ErrorStatus.MISSION_NOT_FOUND));

		// 연관 관계 설정
		newUserMission.setUser(user);
		newUserMission.setMission(mission);

		return userMissionRepository.save(newUserMission);
	}
}
