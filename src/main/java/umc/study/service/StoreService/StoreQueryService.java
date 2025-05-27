package umc.study.service.StoreService;

import umc.study.domain.Store;

import java.math.BigDecimal;
import java.util.List;

public interface StoreQueryService {

    Store findStore(Long id);
    List<Store> findStoresByNameAndScore(String name, BigDecimal rating);
}