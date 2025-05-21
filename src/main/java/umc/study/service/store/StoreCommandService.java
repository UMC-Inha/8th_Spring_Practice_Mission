package umc.study.service.store;

import umc.study.domain.store.Store;
import umc.study.web.controller.store.dto.StoreRequestDTO;

public interface StoreCommandService {
    Store addStore(StoreRequestDTO.AddDto addDto);
}
