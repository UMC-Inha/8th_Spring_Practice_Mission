package umc.study.repository.UserMissionRepository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import umc.study.domain.User;
import umc.study.domain.enums.MissionStatus;
import umc.study.domain.mapping.UserMission;

import java.util.Optional;

public interface UserMissionRepository extends JpaRepository<UserMission, Long>, UserMissionRepositoryCustom {
    // 특정 회원이 특정 미션에 도전 중인지 확인
    boolean existsByUserIdAndMissionIdAndStatus(Long userId, Long missionId, MissionStatus status);
    //boolean existsByMissionIdAndStatus(Long missionId, MissionStatus missionStatus);

    // 회원-미션 관계 조회
    Optional<UserMission> findByUserIdAndMissionId(Long userId, Long missionId);
    // 내가 진행 중인 미션 목록 조회
    Page<UserMission> findAllByUserAndStatus(User user, MissionStatus status, Pageable pageable);

}
