package umc.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import umc.domain.ReviewImg;

import java.util.List;

public interface ReviewImgRepository extends JpaRepository<ReviewImg, Long> {
    @Modifying
    @Query("DELETE FROM ReviewImg ri WHERE ri.review.id IN :reviewIds")
    void deleteAllByReviewIds(@Param("reviewIds") List<Long> reviewIds);
}
