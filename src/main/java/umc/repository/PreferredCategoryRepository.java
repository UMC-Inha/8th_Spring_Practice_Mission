package umc.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import umc.domain.mapping.PreferredCategory;

public interface PreferredCategoryRepository extends JpaRepository<PreferredCategory, Long> {

	@Modifying
	@Query("DELETE FROM PreferredCategory pc WHERE pc.user.id = :userId")
	void deleteAllByUserId(@Param("userId") Long userId);
}
