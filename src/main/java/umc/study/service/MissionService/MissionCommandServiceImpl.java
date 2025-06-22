package umc.study.service.MissionService;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import umc.study.apiPayload.exception.GeneralException;
import umc.study.domain.Mission;
import umc.study.domain.Store;
import umc.study.domain.User;
import umc.study.domain.enums.MissionStatus;
import umc.study.domain.mapping.UserMission;
import umc.study.repository.MissionRepository.MissionRepository;
import umc.study.repository.StoreRepository.StoreRepository;
import umc.study.repository.UserMissionRepository.UserMissionRepository;
import umc.study.repository.UserRepository.UserRepository;
import umc.study.web.dto.MissionRequestDto;
import umc.study.web.dto.MissionResponseDto;
import static umc.study.apiPayload.code.status.ErrorStatus.USER_NOT_FOUND;
import static umc.study.apiPayload.code.status.ErrorStatus._FORBIDDEN;


@Service
@RequiredArgsConstructor
public class MissionCommandServiceImpl {
    private final MissionRepository missionRepository;
    private final StoreRepository storeRepository;
    private final UserRepository userRepository;
    private final UserMissionRepository userMissionRepository;

    @Transactional
    public MissionResponseDto.toResultDto addMission(MissionRequestDto request) {
        // 가게 정보 확인
        Store store = storeRepository.findById(request.getStoreId())
                .orElseThrow(() -> new IllegalArgumentException("Store를 찾을 수 없습니다."));

        // Mission 생성 및 저장
        Mission mission = Mission.builder()
                .missionSpec(request.getMissionSpec())
                .point(request.getPoint())
                .deadline(request.getDeadline())
                .store(store)
                .status(MissionStatus.COMPLETE)  // status 값 기본 설정
                .build();

        Mission savedMission = missionRepository.save(mission);

        MissionResponseDto.toResultDto dto = MissionResponseDto.toResultDto.builder()
                .missionId(savedMission.getId())
                .missionName(savedMission.getMissionSpec())
                .point(savedMission.getPoint())
                .deadline(savedMission.getDeadline())
                .storeName(store.getName())
                .build();
        return dto;
    }

    @Transactional
    public void startMission(Long userId, Long missionId) {
        // 1. User와 Mission 조회
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new GeneralException(USER_NOT_FOUND));
        Mission mission = missionRepository.findById(missionId)
                .orElseThrow(() -> new GeneralException(USER_NOT_FOUND));

        // 2. 이미 도전 중인지 확인
        boolean isAlreadyChallenging = userMissionRepository.existsByUserIdAndMissionIdAndStatus(
                userId, missionId, MissionStatus.CHALLENGING
        );

        if (isAlreadyChallenging) {
            throw new GeneralException(_FORBIDDEN);
        }

        // 3. UserMission 객체 생성 및 저장
        UserMission userMission = UserMission.builder()
                .user(user)
                .mission(mission)
                .status(MissionStatus.CHALLENGING)
                .build();
        userMissionRepository.save(userMission);
    }

    public Page<Mission> getMissionsByStore(Long storeId, Integer page) {
        Store store = storeRepository.findById(storeId).get();

        Page<Mission> MissionPage = missionRepository.findAllByStore(storeId, PageRequest.of(page, 10));
        return MissionPage;
    }
}
