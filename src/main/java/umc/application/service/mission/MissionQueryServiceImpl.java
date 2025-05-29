package umc.application.service.mission;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import umc.common.ApiPayload.code.status.ErrorStatus;
import umc.common.ApiPayload.exception.handler.StoreHandler;
import umc.infrastructure.persistence.entity.mission.Mission;
import umc.infrastructure.persistence.entity.store.Store;
import umc.infrastructure.persistence.repository.mission.MissionRepository;
import umc.infrastructure.persistence.repository.store.StoreRepository;

@Service
@RequiredArgsConstructor
public class MissionQueryServiceImpl implements MissionQueryService{
    private final StoreRepository storeRepository;
    private final MissionRepository missionRepository;

    public Page<Mission> getMissionsByStoreId(Long storeId, Integer page){
        Store store = storeRepository.findById(storeId).orElseThrow(() -> new StoreHandler(ErrorStatus.STORE_NOT_FOUND));
        return missionRepository.findAllByStore(store, PageRequest.of(page, 10));
    }
}
