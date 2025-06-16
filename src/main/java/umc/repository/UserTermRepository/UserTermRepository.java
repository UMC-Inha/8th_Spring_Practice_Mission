package umc.repository.UserTermRepository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import umc.domain.mapping.UserTerm;

public interface UserTermRepository extends JpaRepository<UserTerm, Long> {

	@Modifying
	@Query("DELETE FROM UserTerm ut WHERE ut.user.id = :userId")
	void deleteAllByUserId(@Param("userId") Long userId);
}
