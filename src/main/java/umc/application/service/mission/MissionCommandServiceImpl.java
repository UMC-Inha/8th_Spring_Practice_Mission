package umc.application.service.mission;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import umc.application.converter.MissionConverter;
import umc.common.ApiPayload.code.status.ErrorStatus;
import umc.common.ApiPayload.exception.handler.StoreHandler;
import umc.infrastructure.persistence.entity.mission.Mission;
import umc.infrastructure.persistence.entity.store.Store;
import umc.infrastructure.persistence.repository.mission.MissionRepository;
import umc.infrastructure.persistence.repository.store.StoreRepository;
import umc.presentation.dto.mission.MissionRequestDto;
import umc.presentation.dto.mission.MissionResponseDto;

@Service
@RequiredArgsConstructor
public class MissionCommandServiceImpl implements MissionCommandService{
    private final MissionRepository missionRepository;
    private final StoreRepository storeRepository;

    @Override
    public MissionResponseDto.MissionCreateResponseDto createMission(MissionRequestDto.MissionCreateDto request){
        Store store = storeRepository.findById(request.storeId()).orElseThrow(() -> new StoreHandler(ErrorStatus.STORE_NOT_FOUND));
        Mission mission = MissionConverter.toMission(request);
        mission.setStore(store);
        return MissionConverter.toResponse(missionRepository.save(mission));
    }
}
