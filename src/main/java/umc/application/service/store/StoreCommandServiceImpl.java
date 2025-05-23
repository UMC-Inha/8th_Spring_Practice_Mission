package umc.application.service.store;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import umc.application.converter.StoreConverter;
import umc.common.ApiPayload.code.status.ErrorStatus;
import umc.common.ApiPayload.exception.handler.StoreHandler;
import umc.infrastructure.persistence.entity.store.Store;
import umc.infrastructure.persistence.repository.store.StoreRepository;
import umc.presentation.dto.store.StoreRequestDTO;
import umc.presentation.dto.store.StoreResponseDTO;

@Service
@RequiredArgsConstructor
public class StoreCommandServiceImpl implements StoreCommandService {
    private final StoreRepository storeRepository;

    @Override
    @Transactional
    public StoreResponseDTO.StoreCreateResultDto createStore(StoreRequestDTO.StoreCreateDto request) {
        Store store = StoreConverter.toStore(request);
        return StoreConverter.toStoreCreateResultDto(storeRepository.save(store));
    }
    @Override
    @Transactional
    public StoreResponseDTO.StoreLocationResultDto modifyStoreLocation(StoreRequestDTO.StoreLocationDTO storeLocationDTO){
        Store store = storeRepository.findById(storeLocationDTO.storeId())
                .orElseThrow(() -> new StoreHandler(ErrorStatus.STORE_NOT_FOUND));

        // dirty check
        store.setLocation(storeLocationDTO.location());
        return StoreConverter.toStoreLocationResultDto(store);
    }
}
