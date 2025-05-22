package umc.infrastructure.persistence.repository.mission;



import umc.infrastructure.persistence.entity.mission.Mission;

import java.util.List;

public interface MissionRepository {
    Mission save(Mission mission);
}