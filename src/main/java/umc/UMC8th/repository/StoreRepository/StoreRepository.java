package umc.UMC8th.repository.StoreRepository;

import org.springframework.data.jpa.repository.JpaRepository;
import umc.UMC8th.domain.Store;

public interface StoreRepository extends JpaRepository<Store, Long>, StoreRepositoryCustom {
}
