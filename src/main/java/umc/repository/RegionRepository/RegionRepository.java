package umc.repository.RegionRepository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import umc.domain.Region;

public interface RegionRepository extends JpaRepository<Region, Long> {
	Optional<Region> findByName(String name);
	boolean existsByName(String name);
}
