package umc.service.memberMission;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import umc.apiPayload.code.status.ErrorStatus;
import umc.apiPayload.exception.handler.MemberHandler;
import umc.apiPayload.exception.handler.MissionHandler;
import umc.apiPayload.exception.handler.RestaurantHandler;
import umc.converter.memberMission.MemberMissionConverter;
import umc.domain.Member;
import umc.domain.Mission;
import umc.domain.Restaurant;
import umc.domain.mapping.MemberMission;
import umc.dto.mission.MissionRequestDTO;
import umc.repository.RestaurantRepository.RestaurantRepository;
import umc.repository.member.MemberRepository;
import umc.repository.memberMission.MemberMissionRepository;
import umc.repository.mission.MissionRepository;

import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class MemberMissionService {

    private final MemberMissionRepository memberMissionRepository;
    private final MissionRepository missionRepository;
    private final MemberRepository memberRepository;

    @Transactional
    public void deleteMemberMissionByMember(Long memberId) {

        memberMissionRepository.deleteAllByMemberId(memberId);
    }

    @Transactional
    public MemberMission challengeMission(MissionRequestDTO.ChallengeMissionDto request, Long missionId) {

        Mission findMission = missionRepository.findById(missionId)
                .orElseThrow(() -> new MissionHandler(ErrorStatus.MISSION_NOT_FOUND));

        Member findMember = memberRepository.findById(request.getMemberId())
                .orElseThrow(() -> new MemberHandler(ErrorStatus.MEMBER_NOT_FOUND));

        if (findMission.getDoneAt().isBefore(LocalDateTime.now())) throw new MissionHandler(ErrorStatus.MISSION_ALREADY_DONE);

        MemberMission newMemberMission = MemberMissionConverter.toMemberMission(findMember, findMission);

        memberMissionRepository.save(newMemberMission);

        return newMemberMission;


    }
}
