package umc.repository.review;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import umc.domain.Review;

import java.util.List;
import java.util.Optional;

public interface ReviewRepository extends JpaRepository<Review, Long> {
    @Query("SELECT r.id FROM Review r WHERE r.member.id = :memberId")
    List<Long> findAllReviewIdsByMemberId(@Param("memberId") Long memberId);

    @Modifying
    @Query("DELETE FROM Review r WHERE r.id IN :reviewIds")
    void deleteAllByReviewIds(@Param("reviewIds") List<Long> reviewIds);

    Optional<List<Review>> findAllByRestaurantId(Long restaurantId);
}
