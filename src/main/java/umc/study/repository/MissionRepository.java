package umc.study.repository;

import org.springframework.data.repository.CrudRepository;
import umc.study.domain.Mission;

public interface MissionRepository extends CrudRepository<Mission, Long> {
    Mission getReferenceById(Long id);
}
