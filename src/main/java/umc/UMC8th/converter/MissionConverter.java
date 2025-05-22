package umc.UMC8th.converter;

import umc.UMC8th.domain.Mission;
import umc.UMC8th.domain.Store;
import umc.UMC8th.domain.enums.MissionStatus;
import umc.UMC8th.dto.CreateMissionRequest;

public class MissionConverter {

    public static Mission toMission(CreateMissionRequest request, Store store) {
        return Mission.builder()
                .title(request.getTitle())
                .explanation(request.getExplanation())
                .rewardPoints(request.getRewardPoints())
                .completedNumber(request.getCompletedNumber())
                .deadline(request.getDeadline())
                .store(store)
                .status(MissionStatus.CHALLENGING)
                .build();
    }
}
