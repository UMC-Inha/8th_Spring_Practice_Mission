package umc.study.service.MemberMissionService;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import umc.study.apiPayload.code.status.ErrorStatus;
import umc.study.apiPayload.exception.handler.MemberHandler;
import umc.study.apiPayload.exception.handler.MemberMissionHandler;
import umc.study.apiPayload.exception.handler.MissionHandler;
import umc.study.converter.MemberMissionConverter;
import umc.study.domain.Member;
import umc.study.domain.Mission;
import umc.study.domain.enums.MissionStatus;
import umc.study.domain.mapping.MemberMission;
import umc.study.repository.MemberMissionRepository;
import umc.study.repository.MemberRepository;
import umc.study.repository.MissionRepository;
import umc.study.web.dto.MissionChallengeDTO.MissionChallengeRequestDTO;
import umc.study.web.dto.MissionChallengeDTO.MissionChallengeResponseDTO;

@Service
@RequiredArgsConstructor
public class MemberMissionCommandServiceImpl implements MemberMissionCommandService {
    private final MemberRepository memberRepository;
    private final MissionRepository missionRepository;
    private final MemberMissionRepository memberMissionRepository;
    private final MemberMissionQueryService memberMissionQueryService;

    @Override
    @Transactional
    public MissionChallengeResponseDTO.MissionChallengeJoinResultDTO challengeMission(MissionChallengeRequestDTO.MissionChallengeJoinDTO request) {
        Long memberId = request.getMemberId();
        Long missionId = request.getMissionId();

        Member member = memberRepository.findById(memberId).orElseThrow(() -> new MemberHandler(ErrorStatus.MEMBER_NOT_FOUND));
        Mission mission = missionRepository.findById(missionId).orElseThrow(() -> new MissionHandler(ErrorStatus.MISSION_NOT_FOUND));

        if (memberMissionQueryService.isAlreadyChallenged(memberId, missionId)) {
            throw new MemberMissionHandler(ErrorStatus.MISSION_ALREADY_IN_PROGRESS);
        }

        MemberMission memberMission = MemberMissionConverter.toMemberMission(request, member, mission);
        memberMissionRepository.save(memberMission);

        return MemberMissionConverter.missionChallengeJoinResultDTO(memberMission);
    }

    @Override
    @Transactional
    public void completeMission(Long memberMissionId) {
        MemberMission memberMission = memberMissionRepository.findById(memberMissionId)
                .orElseThrow(() -> new MemberMissionHandler(ErrorStatus.MISSION_NOT_FOUND));

        if (memberMission.getStatus() != MissionStatus.IN_PROGRESS) {
            throw new IllegalStateException("진행 중인 미션만 완료할 수 있습니다.");
        }

        memberMission.markAsDone();


    }
}
