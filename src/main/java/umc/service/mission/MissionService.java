package umc.service.mission;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import umc.apiPayload.code.status.ErrorStatus;
import umc.apiPayload.exception.handler.RestaurantHandler;
import umc.converter.mission.MissionConverter;
import umc.domain.Mission;
import umc.domain.Restaurant;
import umc.dto.mission.MissionRequestDTO;
import umc.repository.RestaurantRepository.RestaurantRepository;
import umc.repository.mission.MissionRepository;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class MissionService {

    private final MissionRepository missionRepository;
    private final RestaurantRepository restaurantRepository;

    @Transactional
    public Mission createMission(MissionRequestDTO.CreateMissionDto request, Long restaurantId) {

        Restaurant findRestaurant = restaurantRepository.findById(restaurantId)
                .orElseThrow(() -> new RestaurantHandler(ErrorStatus.RESTAURANT_NOT_FOUND));

        Mission newMission = MissionConverter.toMission(request, findRestaurant);

        missionRepository.save(newMission);

        return newMission;
    }
}
