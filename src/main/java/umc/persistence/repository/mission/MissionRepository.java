package umc.persistence.repository.mission;

import umc.persistence.entity.mission.Mission;
import umc.presentation.dto.mission.MissionResponse;

import java.util.List;

public interface MissionRepository {
    List<Mission> findMissionByUserAndState(Long userId, String missionState, Integer pagingOffset);

    Long countCompletedMissionRemainder(Long userId, String location);

    List<MissionResponse.MissionCardDto> findNotAcceptedMissions (Long userId, Integer pagingOffset);
}