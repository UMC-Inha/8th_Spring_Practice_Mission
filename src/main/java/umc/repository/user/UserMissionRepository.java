package umc.repository.user;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import umc.domain.Mission;
import umc.domain.User;
import umc.domain.mapping.UserMission;

import java.util.Optional;

public interface UserMissionRepository extends JpaRepository<UserMission, Long> {

    Boolean existsUserMissionByUserAndMission(User user, Mission mission);

    @Query(
            value = "SELECT um " +
                    "FROM UserMission um " +
                    "JOIN FETCH um.mission m " +
                    "WHERE um.user.id = :userId " +
                    "  AND um.isCompleted = false",
            countQuery = "SELECT COUNT(um) " +
                    "FROM UserMission um " +
                    "WHERE um.user.id = :userId " +
                    "  AND um.isCompleted = false"
    )
    Page<UserMission> findOngoingByUserId(
            @Param("userId") Long userId,
            Pageable pageable
    );

    Optional<UserMission> findByUserAndMission(User user, Mission mission);

}
