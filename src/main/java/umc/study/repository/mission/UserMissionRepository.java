package umc.study.repository.mission;

import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Slice;
import org.springframework.data.jpa.repository.JpaRepository;
import umc.study.domain.enums.MissionStatus;
import umc.study.domain.mapping.UserMission;

import java.util.Optional;

public interface UserMissionRepository extends JpaRepository<UserMission, Long> {
    boolean existsByUserIdAndMission_MissionIdAndStatus(Long userId, Long missionId, MissionStatus status);
    Optional<UserMission> findByUserIdAndMission_MissionId(Long userId, Long missionId);
    Slice<UserMission> findByUserIdAndStatus(Long userId, MissionStatus status, Pageable pageable);
}
