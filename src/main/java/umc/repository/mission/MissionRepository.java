package umc.repository.mission;

import umc.entity.mission.Mission;
import umc.presentation.dto.mission.MissionCardDto;

import java.util.List;

public interface MissionRepository {
    List<Mission> findMissionByUserAndState(Long userId, String missionState, Integer pagingOffset);

    Long countCompletedMissionRemainder(Long userId, String location);

    List<MissionCardDto> findNotAcceptedMissions (Long userId, Integer pagingOffset);
}