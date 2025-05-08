package umc.persistence.repository.mission;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import umc.persistence.entity.mission.Mission;

@Repository
public interface JpaMissionRepository extends JpaRepository<Mission, Long> {
}
