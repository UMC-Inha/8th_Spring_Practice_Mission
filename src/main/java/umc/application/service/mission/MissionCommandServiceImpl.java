package umc.application.service.mission;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import umc.application.converter.MissionConverter;
import umc.application.converter.UserMissionConverter;
import umc.common.ApiPayload.code.status.ErrorStatus;
import umc.common.ApiPayload.exception.handler.MissionHandler;
import umc.common.ApiPayload.exception.handler.StoreHandler;
import umc.common.ApiPayload.exception.handler.UserHandler;
import umc.infrastructure.persistence.entity.mission.Mission;
import umc.infrastructure.persistence.entity.mission.MissionState;
import umc.infrastructure.persistence.entity.mission.UserMission;
import umc.infrastructure.persistence.entity.mission.UserMissionPK;
import umc.infrastructure.persistence.entity.store.Store;
import umc.infrastructure.persistence.entity.user.User;
import umc.infrastructure.persistence.repository.mission.MissionRepository;
import umc.infrastructure.persistence.repository.store.StoreRepository;
import umc.infrastructure.persistence.repository.user.UserRepository;
import umc.presentation.dto.mission.MissionRequestDto;
import umc.presentation.dto.mission.MissionResponseDto;

@Service
@RequiredArgsConstructor
public class MissionCommandServiceImpl implements MissionCommandService{
    private final MissionRepository missionRepository;
    private final StoreRepository storeRepository;
    private final UserRepository userRepository;

    @Override
    @Transactional
    public MissionResponseDto.MissionCreateResponseDto createMission(MissionRequestDto.MissionCreateDto request){
        Store store = storeRepository.findById(request.storeId()).orElseThrow(() -> new StoreHandler(ErrorStatus.STORE_NOT_FOUND));
        Mission mission = MissionConverter.toMission(request);
        mission.changeStore(store);
        return MissionConverter.toResponse(missionRepository.save(mission));
    }

    @Override
    @Transactional
    public MissionResponseDto.AddMissionToUserResponseDto addMissionToUser(MissionRequestDto.AddMissionToUserDto request){
        Mission mission = missionRepository.findById(request.missionId()).orElseThrow(() -> new MissionHandler(ErrorStatus.MISSION_NOT_FOUND));
        User user = userRepository.findById(request.userId()).orElseThrow(() -> new UserHandler(ErrorStatus.MEMBER_NOT_FOUND));

        UserMissionPK userMissionPK = UserMissionConverter.toUserMissionPK( user, mission);
        missionRepository.findUserMissionById(userMissionPK).ifPresent(userMission -> {
            throw new MissionHandler(ErrorStatus.MISSION_DUPLICATE_REGISTER);
        });

        UserMission newUserMission = UserMissionConverter.toUserMission(userMissionPK, user, mission);
        missionRepository.save(newUserMission);

        return UserMissionConverter.toResponse(newUserMission);
    }

    @Override
    @Transactional
    public MissionResponseDto.MissionStateChangeResponseDto changeMissionState(Long userId, Long missionId){
        UserMission userMission = missionRepository.findUserMissionById(UserMissionPK.builder().userId(userId).missionId(missionId).build())
                .orElseThrow(() -> new MissionHandler(ErrorStatus.MISSION_NOT_FOUND));
        userMission.setState(MissionState.COMPLETE);
        return UserMissionConverter.toMissionStateChangeResponseDto(userMission);
    }

}
