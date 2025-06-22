package umc.study.service.mission;

import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import umc.study.apiPayload.code.status.ErrorStatus;
import umc.study.apiPayload.exception.GeneralException;
import umc.study.domain.mapping.MemberMission;
import umc.study.domain.member.Member;
import umc.study.domain.mission.Mission;
import umc.study.domain.store.Store;
import umc.study.repository.member.MemberJpaRepository;
import umc.study.repository.member.MemberMissionRepository;
import umc.study.repository.mission.MissionRepository;
import umc.study.repository.store.StoreRepository;
import umc.study.web.controller.mission.dto.MissionRequestDTO.AddMemberMission;
import umc.study.web.controller.mission.dto.MissionRequestDTO.AddMission;
import umc.study.web.controller.mission.dto.MissionRequestDTO.CompleteMission;
import umc.study.web.converter.mission.MissionConverter;

@Service
@RequiredArgsConstructor
public class MissionCommandServiceImpl implements MissionCommandService{
    private final MissionRepository missionRepository;
    private final StoreRepository storeRepository;
    private final MemberJpaRepository memberJpaRepository;
    private final MemberMissionRepository memberMissionRepository;

    @Transactional
    @Override
    public Mission addMissionToStore(AddMission request) {
        Mission mission = MissionConverter.toMission(request);
        Store store = storeRepository.findById(request.getStoreId())
                .orElseThrow(() -> new GeneralException(ErrorStatus.STORE_NOT_FOUND));
        mission.setStore(store);
        Mission saveMission = missionRepository.save(mission);
        return saveMission;
    }

    @Transactional
    @Override
    public Mission addMemberMission(AddMemberMission request) {
        MemberMission memberMission = MissionConverter.toMemberMission(request);
        Mission mission = missionRepository.findById(request.getMissionId()).orElseThrow(() -> new GeneralException(ErrorStatus.MISSION_NOT_FOUND));
        Member member = memberJpaRepository.findById(request.getMemberId()).orElseThrow(() -> new GeneralException(ErrorStatus.MEMBER_NOT_FOUND));
        memberMission.setMemberMission(member, mission);
        memberMissionRepository.save(memberMission);
        return mission;
    }

    @Transactional
    @Override
    public MemberMission completeMission(CompleteMission request) {
        MemberMission memberMission = memberMissionRepository.findById(request.getMemberMissionId())
                .orElseThrow(() -> new GeneralException(ErrorStatus.MISSION_NOT_FOUND));
        memberMission.completeMission();
        return memberMission;
    }
}
