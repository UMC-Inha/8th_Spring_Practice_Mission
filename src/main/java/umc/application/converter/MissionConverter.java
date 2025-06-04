package umc.application.converter;

import org.springframework.data.domain.Page;
import umc.infrastructure.persistence.entity.mission.Mission;
import umc.infrastructure.persistence.entity.mission.UserMissionPK;
import umc.presentation.dto.mission.MissionRequestDto;
import umc.presentation.dto.mission.MissionResponseDto;

import java.util.List;

public class MissionConverter {
    public static Mission toMission(MissionRequestDto.MissionCreateDto request) {
        return Mission.builder()
                .content(request.content())
                .dueDate(request.dueDate())
                .point(request.point())
                .build();
    }

    public static  MissionResponseDto.MissionCreateResponseDto toResponse (Mission mission){
        return MissionResponseDto.MissionCreateResponseDto.builder()
                .missionId(mission.getId())
                .content(mission.getContent())
                .dueDate(mission.getDueDate())
                .createdAt(mission.getCreatedAt())
                .build();
    }

    public static MissionResponseDto.MissionPreviewDto toMissionPreviewDto(Mission mission) {
        return MissionResponseDto.MissionPreviewDto.builder()
                .content(mission.getContent())
                .storeName(mission.getStore().getStoreName())
                .point(mission.getPoint())
                .dueDate(mission.getDueDate())
                .createdAt(mission.getCreatedAt())
                .build();
    }

    public static MissionResponseDto.MissionPreviewListDto toMissionPreviewListDto(Page<Mission> missionList){
        List<MissionResponseDto.MissionPreviewDto> missionPreviewDtoList = missionList.stream()
                .map(MissionConverter::toMissionPreviewDto).toList();
        return MissionResponseDto.MissionPreviewListDto.builder()
                .isLast(missionList.isLast())
                .isFirst(missionList.isFirst())
                .totalPage(missionList.getTotalPages())
                .totalElements(missionList.getTotalElements())
                .listSize(missionPreviewDtoList.size())
                .missionList(missionPreviewDtoList)
                .build();
    }



}
