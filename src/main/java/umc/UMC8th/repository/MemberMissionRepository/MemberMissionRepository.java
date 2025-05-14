package umc.UMC8th.repository.MemberMissionRepository;

import org.springframework.data.jpa.repository.JpaRepository;
import umc.UMC8th.domain.mapping.MemberMission;

public interface MemberMissionRepository extends JpaRepository<MemberMission, Long>, MemberMissionRepositoryCustom {
}
