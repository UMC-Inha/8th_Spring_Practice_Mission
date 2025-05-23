package umc.infrastructure.persistence.repository.mission;



import umc.infrastructure.persistence.entity.mission.Mission;
import umc.infrastructure.persistence.entity.mission.UserMission;
import umc.infrastructure.persistence.entity.mission.UserMissionPK;

import java.util.List;
import java.util.Optional;

public interface MissionRepository {
    Mission save(Mission mission);

    Optional<Mission> findById(Long id);

    void save(UserMission userMission);

    Optional<UserMission> findUserMissionById(UserMissionPK userMissionPK);

}