package umc.persistence.repository.store;

import umc.persistence.entity.store.Store;

import java.util.List;
import java.util.Optional;

public interface StoreRepository {
    List<Store> dynamicQueryWithBooleanBuilder(String name, Float score);

    Optional<Store> findStoreById(Long storeId);
}
