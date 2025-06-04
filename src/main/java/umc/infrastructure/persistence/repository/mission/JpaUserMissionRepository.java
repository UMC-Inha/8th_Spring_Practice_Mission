package umc.infrastructure.persistence.repository.mission;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.repository.JpaRepository;
import umc.infrastructure.persistence.entity.mission.MissionState;
import umc.infrastructure.persistence.entity.mission.UserMission;
import umc.infrastructure.persistence.entity.mission.UserMissionPK;
import umc.infrastructure.persistence.entity.user.User;

public interface JpaUserMissionRepository extends JpaRepository<UserMission, UserMissionPK> {
    Page<UserMission> findByUserAndState(User user, MissionState state, PageRequest pageRequest);

}
