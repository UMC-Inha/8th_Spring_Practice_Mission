package umc.UMC8th.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import umc.UMC8th.domain.Region;

public interface RegionRepository extends JpaRepository<Region, Long> {
}