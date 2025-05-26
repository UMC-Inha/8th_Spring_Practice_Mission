package umc.study.service.mission;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import umc.study.apiPayload.code.status.ErrorStatus;
import umc.study.apiPayload.exception.GeneralException;
import umc.study.domain.store.Store;
import umc.study.repository.mission.MissionRepository;
import umc.study.repository.store.StoreRepository;
import umc.study.web.controller.mission.dto.MissionResponseDTO;
import umc.study.web.converter.mission.MissionConverter;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class MissionQueryServiceImpl implements MissionQueryService {

    private final MissionRepository missionRepository;
    private final StoreRepository storeRepository;

    @Override
    public Page<MissionResponseDTO.MissionPreViewDTO> getMissionListByStore(Long storeId, Pageable pageable) {
        Store store = storeRepository.findById(storeId)
                .orElseThrow(() -> new GeneralException(ErrorStatus.STORE_NOT_FOUND));
        
        return MissionConverter.toMissionPreViewDTOList(
                missionRepository.findAllByStore(store, pageable)
        );
    }
}