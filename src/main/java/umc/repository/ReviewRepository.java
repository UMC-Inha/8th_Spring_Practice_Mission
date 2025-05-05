package umc.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import umc.domain.Review;

public interface ReviewRepository extends JpaRepository<Review, Long> {

	@Modifying
	@Query("DELETE FROM Review r WHERE r.user.id = :userId")
	void deleteAllByUserId(@Param("userId") Long userId);
}
