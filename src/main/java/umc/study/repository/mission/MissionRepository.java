package umc.study.repository.mission;

import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Slice;
import org.springframework.data.jpa.repository.JpaRepository;
import umc.study.domain.mission.Mission;

import java.util.Optional;

public interface MissionRepository extends JpaRepository<Mission,Long> {
    Slice<Mission> findByStoreId(Long storeId, Pageable pageable);
}
