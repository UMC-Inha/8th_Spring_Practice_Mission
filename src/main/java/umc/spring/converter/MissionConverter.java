package umc.spring.converter;

import org.springframework.data.domain.Page;
import umc.spring.domain.Mission;
import umc.spring.domain.Review;
import umc.spring.domain.Store;
import umc.spring.web.dto.mission.MissionRequestDTO;
import umc.spring.web.dto.mission.MissionResponseDTO;
import umc.spring.web.dto.review.ReviewResponseDTO;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

public class MissionConverter {

    public static MissionResponseDTO.CreateMissionResultDto toCreateMissionResultDto(Mission mission){
        return MissionResponseDTO.CreateMissionResultDto.builder()
                .missionId(mission.getId())
                .createdAt(LocalDateTime.now())
                .build();
    }

    public static Mission toMission(MissionRequestDTO.CreateMissionDTO request, Store store){
        return Mission.builder()
                .reward(request.getReward())
                .title(request.getTitle())
                .content(request.getContent())
                .dueDate(request.getDueDate())
                .store(store)
                .build();
    }

    public static MissionResponseDTO.MissionPreviewDto missionPreviewDto(Mission mission) {
        return MissionResponseDTO.MissionPreviewDto.builder()
                .missionId(mission.getId())
                .title(mission.getTitle())
                .content(mission.getContent())
                .reward(mission.getReward())
                .dueDate(mission.getDueDate().toLocalDate())
                .createdAt(mission.getCreatedAt().toLocalDate())
                .build();
    }

    public static MissionResponseDTO.MissionPreviewListResultDto missionPreviewListResultDto (Page<Mission> missionList) {

        List<MissionResponseDTO.MissionPreviewDto> missionPreviewDtoList = missionList.getContent().stream()
                .map(MissionConverter::missionPreviewDto).collect(Collectors.toList());

        return MissionResponseDTO.MissionPreviewListResultDto.builder()
                .isLast(missionList.isLast())
                .isFirst(missionList.isFirst())
                .totalPage(missionList.getTotalPages())
                .totalElements(missionList.getTotalElements())
                .listSize(missionPreviewDtoList.size())
                .missionList(missionPreviewDtoList)
                .build();
    }
}
