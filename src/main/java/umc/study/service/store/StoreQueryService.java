package umc.study.service.store;

import umc.study.domain.store.Store;

import java.util.List;
import java.util.Optional;

// Query Service는 조회(읽기) 책임만 가지는 서비스
// 즉 DB로부터 조회만 하는 것. 순수 SELECT
public interface StoreQueryService {

    Optional<Store> findStore(Long id);
    List<Store> findStoresByNameAndScore(String name, Float score);
}
