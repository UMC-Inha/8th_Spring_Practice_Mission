package umc.study.converter;

import org.springframework.data.domain.Page;
import umc.study.domain.Mission;
import umc.study.domain.Store;
import umc.study.web.dto.request.MissionRequestDTO;
import umc.study.web.dto.response.MissionResponseDTO;

import java.util.List;

public class MissionConverter {
    public static MissionResponseDTO.createResultDTO toCreateResultDTO(Mission mission) {
        return MissionResponseDTO.createResultDTO.builder()
                .missionId(mission.getId())
                .storeId(mission.getStore().getId())
                .createdAt(mission.getCreatedAt())
                .build();
    }

    public static Mission toMission(Store store, MissionRequestDTO.createMissionDTO request) {
        return Mission.builder()
                .store(store)
                .missionSpec(request.getMissionSpec())
                .reward(request.getReward())
                .deadline(request.getDeadline())
                .build();
    }

    public static MissionResponseDTO.MissionPreViewDTO toMissionPreViewDTO(Mission mission) {
        return MissionResponseDTO.MissionPreViewDTO.builder()
                .missionId(mission.getId())
                .missionSpec(mission.getMissionSpec())
                .reward(mission.getReward())
                .deadline(mission.getDeadline())
                .build();
    }

    public static MissionResponseDTO.MissionPreViewListDTO toMissionPreViewListDTO(Page<Mission> missionPage) {
        List<MissionResponseDTO.MissionPreViewDTO> missionPreViewDTOList
                = missionPage.stream().map(MissionConverter::toMissionPreViewDTO).toList();

        return MissionResponseDTO.MissionPreViewListDTO.builder()
                .missionList(missionPreViewDTOList)
                .listSize(missionPage.getNumberOfElements())
                .totalPage(missionPage.getTotalPages())
                .totalElements(missionPage.getTotalElements())
                .isFirst(missionPage.isFirst())
                .isLast(missionPage.isLast())
                .build();
    }
}
