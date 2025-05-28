package umc.converter.mission;

import org.springframework.data.domain.Page;
import umc.domain.Mission;
import umc.domain.Restaurant;
import umc.dto.mission.MissionRequestDTO;
import umc.dto.mission.MissionResponseDTO;
import umc.dto.review.ReviewResponseDTO;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

public class MissionConverter {

    public static MissionResponseDTO.CreateMissionResultDto toCreateMissionResultDto (Mission mission) {
        return MissionResponseDTO.CreateMissionResultDto.builder()
                .missionId(mission.getId())
                .createdAt(LocalDateTime.now())
                .build();
    }

    public static Mission toMission (MissionRequestDTO.CreateMissionDto request, Restaurant restaurant) {
        return Mission.builder()
                .missionPrice(request.getMissionPrice())
                .doneAt(request.getDoneAt())
                .content(request.getContent())
                .reward(request.getReward())
                .restaurant(restaurant)
                .build();
    }

    public static MissionResponseDTO.PreviewMissionDto toPreviewMissionDto (Mission mission) {
        return MissionResponseDTO.PreviewMissionDto.builder()
                .missionPrice(mission.getMissionPrice())
                .content(mission.getContent())
                .reward(mission.getReward())
                .doneAt(mission.getDoneAt().toLocalDate())
                .build();
    }

    public static MissionResponseDTO.PreviewRestaurantMissionListDto previewRestaurantMissionListDto(Page<Mission> missionList) {

        List<MissionResponseDTO.PreviewMissionDto> missionDtoList = missionList.getContent().stream()
                .map(MissionConverter::toPreviewMissionDto).toList();

        return MissionResponseDTO.PreviewRestaurantMissionListDto.builder()
                .missionList(missionDtoList)
                .isFirst(missionList.isFirst())
                .isLast(missionList.isLast())
                .listSize(missionDtoList.size())
                .totalElements(missionList.getTotalElements())
                .totalPage(missionList.getTotalPages())
                .build();
    }
}
