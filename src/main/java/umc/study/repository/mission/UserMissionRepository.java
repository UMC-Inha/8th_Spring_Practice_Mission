package umc.study.repository.mission;

import org.springframework.data.jpa.repository.JpaRepository;
import umc.study.domain.enums.MissionStatus;
import umc.study.domain.mapping.UserMission;

public interface UserMissionRepository extends JpaRepository<UserMission, Long> {
    boolean existsByUserIdAndMissionIdAndStatus(Long userId, Long missionId, MissionStatus status);
}
