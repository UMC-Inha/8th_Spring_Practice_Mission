package umc.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import umc.domain.Qna;

import java.util.List;

public interface QnaRepository extends JpaRepository<Qna, Long> {
    @Query("SELECT q.id FROM Qna q WHERE q.member.id = :memberId")
    List<Long> findAllQnaIdsByMemberId(@Param("memberId") Long memberId);

    @Modifying
    @Query("DELETE FROM Qna q WHERE q.id IN :qnaIds")
    void deleteAllQnaByQnaIds(@Param("qnaIds") List<Long> qnaIds);
}
