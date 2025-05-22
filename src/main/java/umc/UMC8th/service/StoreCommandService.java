package umc.UMC8th.service;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import umc.UMC8th.domain.Region;
import umc.UMC8th.domain.Store;
import umc.UMC8th.dto.CreateStoreRequest;
import umc.UMC8th.repository.RegionRepository;
import umc.UMC8th.repository.StoreRepository.StoreRepository;

@Service
@RequiredArgsConstructor
public class StoreCommandService {

    private final StoreRepository storeRepository;
    private final RegionRepository regionRepository;

    @Transactional
    public Store createStore(CreateStoreRequest request) {
        Region region = regionRepository.findById(request.getRegionId())
                .orElseThrow(() -> new RuntimeException("존재하지 않는 지역입니다."));

        Store store = Store.builder()
                .name(request.getStoreName())
                .address(request.getStoreAddress())
                .region(region)
                .build();

        return storeRepository.save(store);
    }
}
