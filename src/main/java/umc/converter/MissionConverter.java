package umc.converter;

import org.springframework.data.domain.Page;
import umc.converter.user.UserMissionConverter;
import umc.domain.Location;
import umc.domain.Mission;
import umc.domain.Restaurant;
import umc.domain.Review;
import umc.domain.mapping.UserMission;
import umc.web.dto.mission.MissionRequestDTO;
import umc.web.dto.mission.MissionResponseDTO;
import umc.web.dto.restaurant.RestaurantRequestDTO;
import umc.web.dto.review.ReviewResponseDTO;

import java.util.List;
import java.util.stream.Collectors;

public class MissionConverter {

    public static Mission toMission(MissionRequestDTO.createMissionDTO request, Restaurant restaurant) {

        return Mission.builder()
                .name(request.getName())
                .contents(request.getContents())
                .points(request.getPoints())
                .restaurant(restaurant)
                .location(restaurant.getLocation())
                .build();
    }

    public static MissionResponseDTO.MissionDTO toMissionDTO(Mission mission){

        return MissionResponseDTO.MissionDTO.builder()
                .missionName(mission.getName())
                .contents(mission.getContents())
                .points(mission.getPoints())
                .restaurantId(mission.getRestaurant().getId())
                .createdAt(mission.getCreatedAt().toLocalDate())
                .build();
    }

    public static MissionResponseDTO.MissionDTO toMissionDTO(UserMission userMission){

        return MissionResponseDTO.MissionDTO.builder()
                .missionName(userMission.getMission().getName())
                .contents(userMission.getMission().getContents())
                .points(userMission.getMission().getPoints())
                .restaurantId(userMission.getMission().getRestaurant().getId())
                .createdAt(userMission.getMission().getCreatedAt().toLocalDate())
                .build();
    }



    public static MissionResponseDTO.MissionListDTO toMissionListDTO(Page<Mission> missionList){

        List<MissionResponseDTO.MissionDTO> missionDTOList = missionList.stream()
                .map(MissionConverter::toMissionDTO).collect(Collectors.toList());

        return MissionResponseDTO.MissionListDTO.builder()
                .isLast(missionList.isLast())
                .isFirst(missionList.isFirst())
                .totalPage(missionList.getTotalPages())
                .totalElements(missionList.getTotalElements())
                .listSize(missionDTOList.size())
                .missionDTOList(missionDTOList)
                .build();
    }

    public static MissionResponseDTO.MissionListDTO toUserMissionListDTO(Page<UserMission> userMissionList) {

        List<MissionResponseDTO.MissionDTO> userMissionDTOList = userMissionList.stream()
                .map(MissionConverter::toMissionDTO).collect(Collectors.toList());

        return MissionResponseDTO.MissionListDTO.builder()
                .isLast(userMissionList.isLast())
                .isFirst(userMissionList.isFirst())
                .totalPage(userMissionList.getTotalPages())
                .totalElements(userMissionList.getTotalElements())
                .listSize(userMissionDTOList.size())
                .missionDTOList(userMissionDTOList)
                .build();

    }
}
