package umc.converter;

import umc.domain.Location;
import umc.domain.Mission;
import umc.domain.Restaurant;
import umc.web.dto.mission.MissionRequestDTO;
import umc.web.dto.restaurant.RestaurantRequestDTO;

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
}
