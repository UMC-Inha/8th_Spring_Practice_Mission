package umc.repository.UserMissionRepository;

import java.util.List;

import org.springframework.data.domain.Pageable;

import umc.domain.enums.MissionStatus;
import umc.dto.MissionDto;

public interface UserMissionRepositoryCustom {

	List<MissionDto> findMissionByUserIdAndStatus(Long userId, MissionStatus status, Pageable pageable);
	Long countCompletedMissionByUserIdAndRegion(Long userId, String regionName);
}
