package umc.repository.ReviewRepository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import umc.domain.Restaurant;
import umc.domain.Review;
import umc.domain.User;

public interface ReviewRepository extends JpaRepository<Review, Long>, ReviewRepositoryCustom {

	@Modifying
	@Query("DELETE FROM Review r WHERE r.user.id = :userId")
	void deleteAllByUserId(@Param("userId") Long userId);


	Page<Review> findAllByRestaurantAndUser(Restaurant restaurant, User user, PageRequest pageRequest);
}
