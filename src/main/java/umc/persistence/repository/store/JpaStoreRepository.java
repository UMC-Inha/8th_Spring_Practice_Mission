package umc.persistence.repository.store;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import umc.persistence.entity.store.Store;

@Repository
public interface JpaStoreRepository extends JpaRepository<Store, Long> {
}
