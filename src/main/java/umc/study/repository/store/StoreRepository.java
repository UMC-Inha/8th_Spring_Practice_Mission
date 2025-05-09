package umc.study.repository.store;

import org.springframework.data.jpa.repository.JpaRepository;
import umc.study.domain.store.Store;

public interface StoreRepository extends JpaRepository<Store, Long> {
}
