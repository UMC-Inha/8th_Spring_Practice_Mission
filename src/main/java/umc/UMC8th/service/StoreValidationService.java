package umc.UMC8th.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import umc.UMC8th.repository.StoreRepository.StoreRepository;

@Service
@RequiredArgsConstructor
public class StoreValidationService {

    private final StoreRepository storeRepository;

    public boolean isStoreExist(Long storeId) {
        return storeRepository.existsById(storeId);
    }
}

