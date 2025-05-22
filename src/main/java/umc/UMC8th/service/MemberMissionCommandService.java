package umc.UMC8th.service;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import umc.UMC8th.domain.Member;
import umc.UMC8th.domain.Mission;
import umc.UMC8th.domain.enums.MissionStatus;
import umc.UMC8th.domain.mapping.MemberMission;
import umc.UMC8th.dto.MissionChallengeRequest;
import umc.UMC8th.repository.MemberMissionRepository.MemberMissionRepository;
import umc.UMC8th.repository.MemberRepository;
import umc.UMC8th.repository.MissionRepository.MissionRepository;

@Service
@RequiredArgsConstructor
public class MemberMissionCommandService {

    private final MemberRepository memberRepository;
    private final MissionRepository missionRepository;
    private final MemberMissionRepository memberMissionRepository;

    @Transactional
    public MemberMission challengeMission(MissionChallengeRequest request) {
        Member member = memberRepository.findById(1L)
                .orElseThrow(() -> new RuntimeException("존재하지 않는 사용자입니다."));
        Mission mission = missionRepository.findById(request.getMissionId())
                .orElseThrow(() -> new RuntimeException("존재하지 않는 미션입니다."));

        MemberMission memberMission = MemberMission.builder()
                .member(member)
                .mission(mission)
                .status(MissionStatus.CHALLENGING)
                .completedDate(null)
                .build();

        return memberMissionRepository.save(memberMission);
    }
}