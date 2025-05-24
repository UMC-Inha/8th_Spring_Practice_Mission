package umc.study.service.mission;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import umc.study.apiPayload.code.status.ErrorStatus;
import umc.study.apiPayload.exception.handler.MissionHandler;
import umc.study.apiPayload.exception.handler.UserHandler;
import umc.study.converter.UserMissionConverter;
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
    public UserMission challengeMission(UserMissionRequestDto.RegisterDto request) {

        User user = userRepository.findById(request.getUserId())
                .orElseThrow(() -> new UserHandler(ErrorStatus.MEMBER_NOT_FOUND));
        Mission mission = missionRepository.findById(request.getMissionId())
                .orElseThrow(() -> new MissionHandler(ErrorStatus.MEMBER_NOT_FOUND));

        UserMission userMission = UserMissionConverter.toUserMission(user, mission);

        return userMissionRepository.save(userMission);
    }
}