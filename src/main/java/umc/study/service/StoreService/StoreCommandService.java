package umc.study.service.StoreService;

import umc.study.domain.Store;
import umc.study.web.dto.StoreDTO.StoreRequestDTO;

public interface StoreCommandService {
    Store joinStore(StoreRequestDTO.StoreJoinDTO request);

    boolean existById(Long id);
}
