/*package umc.study.repository.MissionRepository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import umc.study.domain.Mission;
import umc.study.domain.enums.MissionStatus;

public interface MissionRepository extends JpaRepository<Mission, Long>, MissionRepositoryCustom {
    // 미션이 이미 도전 중인지 확인
    boolean existsByStatusAndId(MissionStatus status, Long id);
    // 특정 가게의 미션 목록 조회
    Page<Mission> findByStoreId(Long storeId, Pageable pageable);
}
*/