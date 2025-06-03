package umc.study.service.mission;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Slice;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import umc.study.apiPayload.code.status.ErrorStatus;
import umc.study.apiPayload.exception.handler.MissionHandler;
import umc.study.apiPayload.exception.handler.UserHandler;
import umc.study.converter.UserMissionConverter;
import umc.study.domain.enums.MissionStatus;
import umc.study.domain.mapping.UserMission;
import umc.study.domain.mission.Mission;
import umc.study.domain.user.User;
import umc.study.repository.mission.MissionRepository;
import umc.study.repository.mission.UserMissionRepository;
import umc.study.repository.user.UserRepository;
import umc.study.web.dto.request.UserMissionRequestDto;

@Service
@RequiredArgsConstructor
public class UserMissionCommandServiceImpl implements UserMissionCommandService {

    private final UserRepository userRepository;
    private final MissionRepository missionRepository;
    private final UserMissionRepository userMissionRepository;

    @Override
    public Slice<UserMission> findInProgressMissions(Long userId, Integer page, Integer size) {
        Pageable pageable = PageRequest.of(page, size, Sort.by("createdAt").descending());
        Slice<UserMission> userMissionsInProgress = userMissionRepository.findByUserIdAndStatus(
                userId, MissionStatus.IN_PROGRESS, pageable);

        return userMissionsInProgress;
    }

    @Override
    public UserMission challengeMission(UserMissionRequestDto.RegisterDto request) {

        User user = userRepository.findById(request.getUserId())
                .orElseThrow(() -> new UserHandler(ErrorStatus.MEMBER_NOT_FOUND));
        Mission mission = missionRepository.findById(request.getMissionId())
                .orElseThrow(() -> new MissionHandler(ErrorStatus.MEMBER_NOT_FOUND));

        UserMission userMission = UserMissionConverter.toUserMission(user, mission);

        return userMissionRepository.save(userMission);
    }

    @Override
    @Transactional
    public UserMission completeMission(UserMissionRequestDto.CompletedDto request) {

        userRepository.findById(request.getUserId())
                .orElseThrow(() -> new UserHandler(ErrorStatus.MEMBER_NOT_FOUND));
        missionRepository.findById(request.getMissionId())
                .orElseThrow(() -> new MissionHandler(ErrorStatus.MISSION_NOT_FOUND));

        UserMission userMission = userMissionRepository
                .findByUserIdAndMission_MissionId(request.getUserId(), request.getMissionId())
                .orElseThrow(() -> new MissionHandler(ErrorStatus.USER_MISSION_NOT_FOUND));

        userMission.completeUserMission();
        return userMissionRepository.save(userMission);
    }
}