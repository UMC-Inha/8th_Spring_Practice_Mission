package umc.infrastructure.persistence.repository.mission;



import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import umc.infrastructure.persistence.entity.mission.Mission;
import umc.infrastructure.persistence.entity.mission.MissionState;
import umc.infrastructure.persistence.entity.mission.UserMission;
import umc.infrastructure.persistence.entity.mission.UserMissionPK;
import umc.infrastructure.persistence.entity.store.Store;
import umc.infrastructure.persistence.entity.user.User;

import java.util.List;
import java.util.Optional;

public interface MissionRepository {
    Mission save(Mission mission);

    Optional<Mission> findById(Long id);

    void save(UserMission userMission);

    Optional<UserMission> findUserMissionById(UserMissionPK userMissionPK);

    Page<Mission> findAllByStore(Store store, PageRequest pageRequest);

    Page<Mission> findAllByUserAndState(User user, MissionState missionState, PageRequest pageRequest);

    UserMission updateStateOfUserMission(Long userId, Long missionId);

}