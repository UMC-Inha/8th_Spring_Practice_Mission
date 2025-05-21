package umc.service.mission;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import umc.apiPayload.code.status.ErrorStatus;
import umc.apiPayload.exception.GeneralException;
import umc.converter.MissionConverter;
import umc.domain.Mission;
import umc.domain.Restaurant;
import umc.repository.mission.MissionRepository;
import umc.repository.restaurant.RestaurantRepository;
import umc.web.dto.mission.MissionRequestDTO;

@Service
@RequiredArgsConstructor
@Transactional
public class MissionCommandServiceImpl implements MissionCommandService {

    private final MissionRepository missionRepository;
    private final RestaurantRepository restaurantRepository;

    @Override
    public void createMission(MissionRequestDTO.createMissionDTO request, Long restaurantId) {

        // @Validated로 앞에서 미리 유효성 검사 진행
        Restaurant restaurant = restaurantRepository.findById(restaurantId).orElseThrow(
                () -> new GeneralException(ErrorStatus.RESTAURANT_NOT_FOUND)
        );

        Mission mission = MissionConverter.toMission(request, restaurant);

        missionRepository.save(mission);

    }
}
