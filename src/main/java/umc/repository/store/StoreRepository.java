package umc.repository.store;

import umc.entity.store.Store;

import java.util.List;

public interface StoreRepository {
    List<Store> dynamicQueryWithBooleanBuilder(String name, Float score);
}
