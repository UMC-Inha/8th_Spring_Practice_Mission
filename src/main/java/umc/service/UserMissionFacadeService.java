package umc.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestParam;

import lombok.RequiredArgsConstructor;
import umc.dto.ChallengeMissionDto;
import umc.repository.UserMissionRepository;

@Service
@RequiredArgsConstructor
public class UserMissionFacadeService {

	private final UserMissionService userMissionService;
	private final UserMissionRepository userMissionRepository;

	@Transactional
	public ChallengeMissionDto challengeMission(Long userId, Long missionId) {

		String lockName = "user_mission_lock_" + userId + "_" + missionId;
		boolean lockAcquired = userMissionRepository.acquireLock(lockName);

		if (!lockAcquired) {
			throw new RuntimeException("다른 요청이 처리 중입니다. 재시도하세요");
		}

		try {
			return userMissionService.challengeMission(userId, missionId);
		} catch (RuntimeException e) {
			throw new RuntimeException(e.getMessage(), e);
		} finally {
			userMissionRepository.releaseLock(lockName);
		}
	}
}
