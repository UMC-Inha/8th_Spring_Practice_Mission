package umc.application.service.store;

import umc.presentation.dto.store.StoreRequestDTO;
import umc.presentation.dto.store.StoreResponseDTO;

public interface StoreCommandService {


    StoreResponseDTO.StoreLocationResultDto modifyStoreLocation(StoreRequestDTO.StoreLocationDTO storeLocationDTO);
}
