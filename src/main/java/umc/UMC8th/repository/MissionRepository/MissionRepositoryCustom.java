package umc.UMC8th.repository.MissionRepository;

import umc.UMC8th.dto.HomeMissionResponse;

import java.util.List;

public interface MissionRepositoryCustom {
    List<HomeMissionResponse> findHomeMissionsByRegionAndMember(String regionName, Long memberId, int offset, int limit);
}
