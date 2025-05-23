package umc.infrastructure.persistence.repository.store;

import umc.infrastructure.persistence.entity.store.Store;

import java.util.List;
import java.util.Optional;

public interface StoreRepository {

    Store save(Store store);

    Optional<Store> findById(Long storeId);

    boolean existsById(Long id);
}
