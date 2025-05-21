package umc.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import lombok.RequiredArgsConstructor;
import umc.domain.Mission;
import umc.domain.User;
import umc.domain.mapping.UserMission;
import umc.dto.ChallengeMissionDto;
import umc.repository.MissionRepository.MissionRepository;
import umc.repository.UserMissionRepository.UserMissionRepository;
import umc.repository.UserRepository.UserRepository;

@Service
@RequiredArgsConstructor
public class UserMissionService {

	private final UserRepository userRepository;
	private final MissionRepository missionRepository;
	private final UserMissionRepository userMissionRepository;

	@Transactional(propagation = Propagation.REQUIRES_NEW)
	public ChallengeMissionDto challengeMission(Long userId, Long missionId) {

		User user = userRepository.findById(userId).orElseThrow(() -> new RuntimeException("존재하지 않는 유저입니다."));

		Mission mission = missionRepository.findById(missionId)
			.orElseThrow(() -> new RuntimeException("존재하지 않는 미션입니다."));

		UserMission userMission = UserMission.builder()
			.user(user)
			.mission(mission)
			.build();

		userMissionRepository.save(userMission);

		return new ChallengeMissionDto(true, userMission.getId());
	}
}
