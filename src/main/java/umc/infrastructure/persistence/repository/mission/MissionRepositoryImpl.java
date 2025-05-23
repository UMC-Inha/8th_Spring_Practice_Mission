package umc.infrastructure.persistence.repository.mission;


import jakarta.persistence.EntityManager;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import umc.infrastructure.persistence.entity.mission.Mission;
import umc.infrastructure.persistence.entity.mission.UserMission;
import umc.infrastructure.persistence.entity.mission.UserMissionPK;


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
}
