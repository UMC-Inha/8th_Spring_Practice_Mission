package umc.study.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;
import umc.study.domain.Mission;

public interface MissionRepository extends CrudRepository<Mission, Long> {
    Mission getReferenceById(Long id);

    Page<Mission> findAllByStoreId(Long storeId, Pageable pageable);
}
