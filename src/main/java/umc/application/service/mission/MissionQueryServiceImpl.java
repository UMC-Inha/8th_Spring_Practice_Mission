package umc.application.service.mission;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import umc.common.ApiPayload.code.status.ErrorStatus;
import umc.common.ApiPayload.exception.handler.StoreHandler;
import umc.common.ApiPayload.exception.handler.UserHandler;
import umc.infrastructure.persistence.entity.mission.Mission;
import umc.infrastructure.persistence.entity.store.Store;
import umc.infrastructure.persistence.entity.user.User;
import umc.infrastructure.persistence.repository.mission.MissionRepository;
import umc.infrastructure.persistence.repository.store.StoreRepository;
import umc.infrastructure.persistence.repository.user.UserRepository;

@Service
@RequiredArgsConstructor
public class MissionQueryServiceImpl implements MissionQueryService{
    private final StoreRepository storeRepository;
    private final MissionRepository missionRepository;
    private final UserRepository userRepository;

    @Override
    public Page<Mission> getMissionsByStoreId(Long storeId, Integer page){
        Store store = storeRepository.findById(storeId).orElseThrow(() -> new StoreHandler(ErrorStatus.STORE_NOT_FOUND));
        return missionRepository.findAllByStore(store, PageRequest.of(page, 10));
    }

    @Override
    public Page<Mission> getMissionsByUserId(Long userId, Integer page){
        User user = userRepository.findById(userId).orElseThrow(() -> new UserHandler(ErrorStatus.MEMBER_NOT_FOUND));
        return missionRepository.findAllByUser(user, PageRequest.of(page, 10));
    }
}
