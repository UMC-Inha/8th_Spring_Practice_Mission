package umc.study.service.StoreService;

import umc.study.domain.Store;

import java.util.List;

public interface StoreQueryService {

    Store findStore(Long id);
    List<Store> findStoresByNameAndScore(String name, Float score);
}