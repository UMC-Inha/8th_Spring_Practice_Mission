package umc.infrastructure.persistence.repository.mission;


import jakarta.persistence.EntityManager;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Repository;
import umc.infrastructure.persistence.entity.mission.Mission;
import umc.infrastructure.persistence.entity.mission.MissionState;
import umc.infrastructure.persistence.entity.mission.UserMission;
import umc.infrastructure.persistence.entity.mission.UserMissionPK;
import umc.infrastructure.persistence.entity.store.Store;
import umc.infrastructure.persistence.entity.user.User;


import java.util.List;
import java.util.Optional;

@Repository
@RequiredArgsConstructor
public class MissionRepositoryImpl implements MissionRepository {
    private final JpaMissionRepository jpaMissionRepository;
    private final JpaUserMissionRepository jpaUserMissionRepository;
    private final EntityManager entityManager;


    @Override
    public void save(UserMission userMission) {
        entityManager.persist(userMission);
    }

    @Override
    public Mission save(Mission mission) {
        return jpaMissionRepository.save(mission);
    }

    @Override
    public Optional<Mission> findById(Long id) {
        return jpaMissionRepository.findById(id);
    }


    @Override
    public Optional<UserMission> findUserMissionById(UserMissionPK userMissionPK) {
        return jpaUserMissionRepository.findById(userMissionPK);
    }

    @Override
    public Page<Mission> findAllByStore(Store store, PageRequest pageRequest){
        return jpaMissionRepository.findAllByStore(store, pageRequest);
    }

    @Override
    public Page<Mission> findAllByUserAndState(User user, MissionState missionState, PageRequest pageRequest) {
        Page<UserMission> userMissions = jpaUserMissionRepository.findByUserAndState(user, missionState, pageRequest);
        return userMissions.map(UserMission::getMission);
    }
}
