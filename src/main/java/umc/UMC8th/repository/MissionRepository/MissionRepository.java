package umc.UMC8th.repository.MissionRepository;

import org.springframework.data.jpa.repository.JpaRepository;
import umc.UMC8th.domain.Mission;

public interface MissionRepository extends JpaRepository<Mission, Long>, MissionRepositoryCustom {
}
