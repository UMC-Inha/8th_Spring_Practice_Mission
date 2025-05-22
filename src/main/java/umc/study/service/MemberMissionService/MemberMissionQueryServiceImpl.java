package umc.study.service.MemberMissionService;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import umc.study.domain.Member;
import umc.study.domain.Mission;
import umc.study.domain.enums.MissionStatus;
import umc.study.repository.MemberMissionRepository;
import umc.study.repository.MemberRepository;
import umc.study.repository.MissionRepository;

@Service
@RequiredArgsConstructor
public class MemberMissionQueryServiceImpl implements MemberMissionQueryService {
    private final MemberRepository memberRepository;
    private final MissionRepository missionRepository;
    private final MemberMissionRepository memberMissionRepository;

    @Override
    public boolean isAlreadyChallenged(Long memberId, Long missionId) {
        Member member = memberRepository.findById(memberId).orElse(null);
        Mission mission = missionRepository.findById(missionId).orElse(null);

        if (member == null || mission == null) return false;

        return memberMissionRepository.existsByMemberAndMissionAndStatus(
                member, mission, MissionStatus.IN_PROGRESS
        );
    }
}
