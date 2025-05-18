package umc.study.repository.MissionRepository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import umc.study.domain.enums.MissionStatus;
import umc.study.dto.MemberMissionDto;
import umc.study.dto.RegionMissionDto;

public interface MissionRepositoryCustom {
    public Page<MemberMissionDto> findByMemberAndStatus(Long memberId, MissionStatus status, Pageable pageable);

    public Page<RegionMissionDto> findByRegion(Long regionId, Pageable pageable);
}
