package umc.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import umc.domain.Answer;

import java.util.List;

public interface AnswerRepository extends JpaRepository<Answer, Long> {
    @Modifying
    @Query("DELETE FROM Answer a WHERE a.review.id IN :reviewIds")
    void deleteAllByReviewIds(@Param("reviewIds") List<Long> reviewIds);
}
