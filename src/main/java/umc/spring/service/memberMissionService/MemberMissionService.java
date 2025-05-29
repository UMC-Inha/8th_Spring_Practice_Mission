package umc.spring.service.memberMissionService;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import umc.spring.apiPayload.Exception.handler.MemberHandler;
import umc.spring.apiPayload.Exception.handler.MissionHandler;
import umc.spring.apiPayload.Exception.handler.StoreHandler;
import umc.spring.apiPayload.code.status.ErrorStatus;
import umc.spring.converter.MemberMissionConverter;
import umc.spring.domain.Member;
import umc.spring.domain.Mission;
import umc.spring.domain.Store;
import umc.spring.domain.mapping.MemberMission;
import umc.spring.repository.member.MemberRepository;
import umc.spring.repository.memberMission.MemberMissionRepository;
import umc.spring.repository.mission.MissionRepository;
import umc.spring.web.dto.mission.MissionRequestDTO;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class MemberMissionService {

    private final MemberMissionRepository memberMissionRepository;
    private final MissionRepository missionRepository;
    private final MemberRepository memberRepository;

    @Transactional
    public MemberMission challengeMission(MissionRequestDTO.ChallengeMissionDto request, Long missionId){

        Mission findMission = missionRepository.findById(missionId)
                .orElseThrow(() -> new MissionHandler(ErrorStatus.MISSION_NOT_FOUND));

        Member findMember = memberRepository.findById(request.getMemberId())
                .orElseThrow(() -> new MemberHandler(ErrorStatus.MEMBER_NOT_FOUND));

        MemberMission newMemberMission = MemberMissionConverter.toMemberMission(findMember, findMission);

        memberMissionRepository.save(newMemberMission);

        return newMemberMission;
    }

    @Transactional
    public Page<MemberMission> getMissionListByMember(Long memberId, Integer page) {
        Member member = memberRepository.findById(memberId)
                .orElseThrow(() -> new MemberHandler(ErrorStatus.MEMBER_NOT_FOUND));

        Page<MemberMission> MemberMissionPage = memberMissionRepository.findAllByMember(member, PageRequest.of(page, 10));
        return MemberMissionPage;
    }

    @Transactional
    public MemberMission changeMissionStatusByMember(Long missionId, Long memberId) {
        Mission mission = missionRepository.findById(missionId)
                .orElseThrow(() -> new MissionHandler(ErrorStatus.MISSION_NOT_FOUND));

        Member member = memberRepository.findById(memberId)
                .orElseThrow(() -> new MemberHandler(ErrorStatus.MEMBER_NOT_FOUND));

        MemberMission memberMission = memberMissionRepository.findByMissionAndMember(mission, member);
        memberMission.changeMissionStatus();
        return memberMission;
    }

}
