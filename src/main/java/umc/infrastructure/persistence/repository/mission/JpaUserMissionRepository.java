package umc.infrastructure.persistence.repository.mission;

import org.springframework.data.jpa.repository.JpaRepository;
import umc.infrastructure.persistence.entity.mission.UserMission;
import umc.infrastructure.persistence.entity.mission.UserMissionPK;

public interface JpaUserMissionRepository extends JpaRepository<UserMission, UserMissionPK> {
}
