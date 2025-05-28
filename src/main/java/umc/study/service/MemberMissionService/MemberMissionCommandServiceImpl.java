package umc.study.service.MemberMissionService;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import umc.study.converter.MemberMissionConverter;
import umc.study.domain.Member;
import umc.study.domain.Mission;
import umc.study.domain.mapping.MemberMission;
import umc.study.repository.MemberMissionRepository.MemberMissionRepository;
import umc.study.repository.MemberRepository;
import umc.study.repository.MissionRepository;
import umc.study.web.dto.request.MemberMissionRequestDTO;

@Service
@RequiredArgsConstructor
public class MemberMissionCommandServiceImpl implements MemberMissionCommandService {
    private final MemberRepository memberRepository;
    private final MissionRepository missionRepository;
    private final MemberMissionRepository memberMissionRepository;

    @Override
    @Transactional
    public MemberMission createMemberMission(MemberMissionRequestDTO.createChallengeDTO request) {
        Member member = memberRepository.getReferenceById(request.getMemberId());
        Mission mission = missionRepository.getReferenceById(request.getMissionId());

        MemberMission memberMission = MemberMissionConverter.toMemberMission(member);
        memberMission.changeMission(mission);
        memberMissionRepository.save(memberMission);

        return memberMission;
    }
}
