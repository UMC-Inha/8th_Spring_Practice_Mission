package umc.repository.MissionRepository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import umc.domain.Mission;

public interface MissionRepository extends JpaRepository<Mission, Long>, MissionRepositoryCustom {

	@Query("""
        SELECT m
        FROM Mission m
        WHERE m.restaurant.id = :restaurantId
        AND m.id NOT IN (
            SELECT um.mission.id
            FROM UserMission um
            WHERE um.user.id = :userId
        )
    """)
	Page<Mission> findAllNotInUserMission(@Param("restaurantId") Long restaurantId,
		@Param("userId") Long userId,
		Pageable pageable);
}
