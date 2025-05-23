package umc.application.service.store;

import umc.presentation.dto.store.StoreRequestDTO;
import umc.presentation.dto.store.StoreResponseDTO;

public interface StoreCommandService {

    StoreResponseDTO.StoreCreateResultDto createStore(StoreRequestDTO.StoreCreateDto request);
    StoreResponseDTO.StoreLocationResultDto modifyStoreLocation(StoreRequestDTO.StoreLocationDTO storeLocationDTO);
}
