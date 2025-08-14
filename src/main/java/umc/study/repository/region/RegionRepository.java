package umc.study.repository.region;

import org.springframework.data.jpa.repository.JpaRepository;
import umc.study.domain.region.Region;

public interface RegionRepository extends JpaRepository<Region, Long> {
}
