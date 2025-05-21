package umc.study.repository.mission;

import org.springframework.data.jpa.repository.JpaRepository;
import umc.study.domain.mission.Mission;

public interface MissionRepository extends JpaRepository<Mission, Long> {
}
