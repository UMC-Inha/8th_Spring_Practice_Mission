package umc.UMC8th.service;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import umc.UMC8th.domain.Mission;
import umc.UMC8th.domain.Store;
import umc.UMC8th.domain.enums.MissionStatus;
import umc.UMC8th.dto.CreateMissionRequest;
import umc.UMC8th.repository.MissionRepository.MissionRepository;
import umc.UMC8th.repository.StoreRepository.StoreRepository;

@Service
@RequiredArgsConstructor
public class MissionService {

    private final StoreRepository storeRepository;
    private final MissionRepository missionRepository;

    @Transactional
    public Mission createMission(CreateMissionRequest request) {
        // 존재하는 가게인지 검증
        Store store = storeRepository.findById(request.getStoreId())
                .orElseThrow(() -> new RuntimeException("존재하지 않는 가게입니다."));

        // Mission 엔티티 생성
        Mission mission = Mission.builder()
                .title(request.getTitle())
                .explanation(request.getExplanation())
                .rewardPoints(request.getRewardPoints())
                .completedNumber(request.getCompletedNumber())
                .deadline(request.getDeadline())
                .store(store)
                .status(MissionStatus.CHALLENGING) // 기본값 = 도전중
                .build();

        return missionRepository.save(mission);
    }
}
