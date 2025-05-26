package umc.study.service.StoreService;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import umc.study.domain.Store;
import umc.study.web.dto.Mission.MissionResponseDto;
import umc.study.web.dto.Store.StoreRequestDto;

import java.util.List;
import java.util.Optional;

public interface StoreQueryService {

    Optional<Store> findStore(Long id);
    List<Store> findStoresByNameAndScore(String name, Float score);
    Page<MissionResponseDto.JoinResultDTO> findStoreMissions(Long storeId, Pageable pageable);
    Store registerStore(StoreRequestDto.JoinDto request);
}
