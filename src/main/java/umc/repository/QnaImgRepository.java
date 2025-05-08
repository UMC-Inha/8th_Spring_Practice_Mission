package umc.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import umc.domain.QnaImg;

import java.util.List;

public interface QnaImgRepository extends JpaRepository<QnaImg, Long> {
    @Modifying
    @Query("DELETE FROM QnaImg qi WHERE qi.qna.id IN :qnaIds")
    void deleteAllByQnaIds(@Param("qnaIds") List<Long> qnaIds);
}
