package umc.UMC8th.repository.StoreRepository;

import umc.UMC8th.domain.Store;

import java.util.List;

public interface StoreRepositoryCustom {
    List<Store> dynamicQueryWithBooleanBuilder(String name, Float score);
}
