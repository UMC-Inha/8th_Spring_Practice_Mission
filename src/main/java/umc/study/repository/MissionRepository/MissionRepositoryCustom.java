/*package umc.study.repository.MissionRepository;

import org.springframework.data.domain.Page;
import umc.study.web.dto.MissionDto;

import java.awt.print.Pageable;
import java.util.List;

public interface MissionRepositoryCustom {
    //Page<MissionDto> findMissionByRegion(long regionId, org.springframework.data.domain.Pageable pageable);
    Page<MissionDto> findAvailableMissionsByUserAndRegion(Long userId, Long regionId, Pageable pageable);
    Long countCompletedMissionsByUserAndRegionId(Long userId, Long regionId);
}*/
