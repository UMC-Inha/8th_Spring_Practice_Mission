package umc.study.service.StoreService;

import org.springframework.data.domain.Page;
import umc.study.domain.Review;
import umc.study.domain.Store;

import java.math.BigDecimal;
import java.util.List;

public interface StoreQueryService {

    Store findStore(Long id);
    List<Store> findStoresByNameAndScore(String name, BigDecimal rating);
}