package umc.repository.UserMissionRepository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import umc.domain.mapping.UserMission;

public interface UserMissionRepository extends JpaRepository<UserMission, Long>, UserMissionRepositoryCustom {

	// 락 획득
	@Modifying
	@Query(value = "SELECT GET_LOCK(:lockName, 10)", nativeQuery = true)
	boolean acquireLock(@Param("lockName") String lockName);

	// 락 해제
	@Modifying
	@Query(value = "SELECT RELEASE_LOCK(:lockName)", nativeQuery = true)
	void releaseLock(@Param("lockName") String lockName);
}
