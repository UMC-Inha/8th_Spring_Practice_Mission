package umc.repository.MissionRepository;

import java.util.List;

import org.springframework.data.domain.Pageable;

import umc.dto.MissionDto;

public interface MissionRepositoryCustom {

	List<MissionDto> findMissionsByRegionIdNotInUserMission(Long userId, Long regionId, Pageable pageable);
}
