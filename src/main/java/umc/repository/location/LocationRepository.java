package umc.repository.location;

import org.springframework.data.jpa.repository.JpaRepository;
import umc.domain.Location;

public interface LocationRepository extends JpaRepository<Location, Long> {
}
