package umc.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import umc.domain.Alarm;

public interface AlarmRepository extends JpaRepository<Alarm, Long> {

	@Modifying
	@Query("DELETE FROM Alarm a WHERE a.user.id = :userId")
	void deleteAllByUserId(@Param("userId") Long userId);
}