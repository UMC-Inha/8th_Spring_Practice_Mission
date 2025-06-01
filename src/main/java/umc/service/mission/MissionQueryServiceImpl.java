package umc.service.mission;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import umc.apiPayload.code.status.ErrorStatus;
import umc.apiPayload.exception.GeneralException;
import umc.domain.Mission;
import umc.domain.Restaurant;
import umc.domain.User;
import umc.domain.mapping.UserMission;
import umc.repository.mission.MissionRepository;
import umc.repository.restaurant.RestaurantRepository;
import umc.repository.user.UserMissionRepository;
import umc.repository.user.UserRepository;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class MissionQueryServiceImpl implements MissionQueryService {

    private final MissionRepository missionRepository;
    private final RestaurantRepository restaurantRepository;
    private final UserRepository userRepository;
    private final UserMissionRepository userMissionRepository;

    @Override
    public Page<Mission> getMissionListByRestaurantId(Long restaurantId, Integer page) {

        Restaurant restaurant = restaurantRepository.findById(restaurantId).orElseThrow(
                () -> new GeneralException(ErrorStatus.RESTAURANT_NOT_FOUND)
        );

        Page<Mission> missionPage = missionRepository.findAllByRestaurant(restaurant, PageRequest.of(page, 10));
        return missionPage;
    }

    @Override
    public Page<UserMission> getMissionListByUserId(Long userId, Integer page) {

        User user = userRepository.findById(userId).orElseThrow(
                () -> new GeneralException(ErrorStatus.USER_NOT_FOUND)
        );

        Page<UserMission> userMissionPage = userMissionRepository.findOngoingByUserId(userId, PageRequest.of(page, 10));

        return userMissionPage;
    }


}
