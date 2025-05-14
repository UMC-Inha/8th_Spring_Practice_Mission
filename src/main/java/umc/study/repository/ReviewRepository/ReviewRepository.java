package umc.study.repository.ReviewRepository;

import jakarta.transaction.Transactional;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import umc.study.domain.Review;

import java.math.BigDecimal;
import java.util.Optional;

@Repository
public interface ReviewRepository extends JpaRepository<Review, Long>, ReviewRepositoryCustom{
    @Modifying
    @Transactional
    @Query(value = "INSERT INTO Review (user_id, store_id, content, rating) VALUES (:userId, :storeId, :content, :rating)", nativeQuery = true)
    void insertReview(@Param("memberId") Long userId,
                      @Param("storeId") Long storeId,
                      @Param("content") String content,
                      @Param("rating") BigDecimal rating
    );

    Page<Review> findByUserId(long id, Pageable unpaged);
}
