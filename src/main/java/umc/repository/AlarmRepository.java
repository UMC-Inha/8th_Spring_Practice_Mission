package umc.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import umc.domain.Alarm;

public interface AlarmRepository extends JpaRepository<Alarm, Long> {
    void deleteAllByMemberId(Long memberId);
}
