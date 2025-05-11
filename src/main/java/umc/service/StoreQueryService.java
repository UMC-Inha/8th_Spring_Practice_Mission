package umc.service;

import umc.persistence.entity.store.Store;

import java.util.List;
import java.util.Optional;

public interface StoreQueryService {
    Optional<Store> findStoreById(Long storeId);
    List<Store> findStoresByNameAndScore(String name, Float score);

}
