package umc.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import umc.domain.AgreeSet;

public interface AgreeSetRepository extends JpaRepository<AgreeSet, Long> {
    void deleteAllByMemberId(Long memberId);
}
