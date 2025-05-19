package umc.study.service.MissionService;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import umc.study.apiPayload.code.status.ErrorStatus;
import umc.study.apiPayload.exception.GeneralException;
import umc.study.converter.MissionConverter;
import umc.study.domain.Mission;
import umc.study.domain.Store;
import umc.study.repository.MissionRepository.MissionRepository;
import umc.study.repository.StoreRepository.StoreRepository;
import umc.study.web.dto.Mission.MissionRequestDto;

@Service
@RequiredArgsConstructor
public class MissionCommandServiceImpl implements MissionCommandService {

    private final MissionRepository missionRepository;

    private final StoreRepository storeRepository;

    @Override
    public Mission registerMission(MissionRequestDto.JoinDto request) {
        Mission mission = MissionConverter.toMission(request);

        Store store = storeRepository.findById(request.getStoreId()).orElseThrow(() -> new GeneralException(ErrorStatus.STORE_NOT_FOUND));;

        mission.setStore(store);

        return missionRepository.save(mission);
    }
}
