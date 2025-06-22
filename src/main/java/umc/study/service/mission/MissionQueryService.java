package umc.study.service.mission;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import umc.study.web.controller.mission.dto.MissionResponseDTO;

public interface MissionQueryService {
    Page<MissionResponseDTO.MissionPreViewDTO> getMissionListByStore(Long storeId, Pageable pageable);
}
