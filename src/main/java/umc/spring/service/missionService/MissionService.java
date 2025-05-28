package umc.spring.service.missionService;


import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import umc.spring.apiPayload.Exception.handler.StoreHandler;
import umc.spring.apiPayload.code.status.ErrorStatus;
import umc.spring.converter.MissionConverter;
import umc.spring.domain.Mission;
import umc.spring.domain.Store;
import umc.spring.repository.StoreRepository.StoreRepository;
import umc.spring.repository.mission.MissionRepository;
import umc.spring.web.dto.mission.MissionRequestDTO;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class MissionService {

    private final MissionRepository missionRepository;
    private final StoreRepository storeRepository;

    @Transactional
    public Mission CreateMission(MissionRequestDTO.CreateMissionDTO request, Long storeId){
        Store findStore = storeRepository.findById(storeId)
                .orElseThrow(() -> new StoreHandler(ErrorStatus.Store_NOT_FOUND));

        Mission newMission = MissionConverter.toMission(request, findStore);

        missionRepository.save(newMission);

        return newMission;
    }
}
