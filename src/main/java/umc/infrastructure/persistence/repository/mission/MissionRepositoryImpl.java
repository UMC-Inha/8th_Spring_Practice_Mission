package umc.infrastructure.persistence.repository.mission;


import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import umc.infrastructure.persistence.entity.mission.Mission;


import java.util.List;

@Repository
@RequiredArgsConstructor
public class MissionRepositoryImpl implements MissionRepository {
    private final JpaMissionRepository jpaMissionRepository;
    @Override
    public Mission save(Mission mission) {
        return jpaMissionRepository.save(mission);
    }

}
