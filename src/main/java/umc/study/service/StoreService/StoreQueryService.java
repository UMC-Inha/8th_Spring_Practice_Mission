package umc.study.service.StoreService;

import umc.study.domain.Store;
import umc.study.web.dto.Store.StoreRequestDto;

import java.util.List;
import java.util.Optional;

public interface StoreQueryService {

    Optional<Store> findStore(Long id);
    List<Store> findStoresByNameAndScore(String name, Float score);
    Store registerStore(StoreRequestDto.JoinDto request);
}
