package umc.study.service.mission;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import umc.study.apiPayload.code.status.ErrorStatus;
import umc.study.apiPayload.exception.handler.StoreHandler;
import umc.study.converter.MissionConverter;
import umc.study.domain.mission.Mission;
import umc.study.domain.store.Store;
import umc.study.repository.mission.MissionRepository;
import umc.study.repository.store.StoreRepository;
import umc.study.web.dto.request.MissionRequestDto;

@Service
@RequiredArgsConstructor
public class MissionCommandServiceImpl implements MissionCommandService {

    private final StoreRepository storeRepository;
    private final MissionRepository missionRepository;

    @Override
    public Mission registerMission(MissionRequestDto.RegisterDto request) {
        Store store = storeRepository.findById(request.getStoreId())
                .orElseThrow(() -> new StoreHandler(ErrorStatus.STORE_NOT_FOUND));
        Mission mission = MissionConverter.toMission(request, store);
        return missionRepository.save(mission);
    }
}
