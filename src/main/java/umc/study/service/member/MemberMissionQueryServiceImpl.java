package umc.study.service.member;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import umc.study.domain.enums.MissionStatus;
import umc.study.repository.member.MemberMissionRepositoryImpl;
import umc.study.repository.member.dto.MemberMissionByLocationResponseDto;
import umc.study.repository.member.dto.MemberMissionIsCompletedResponseDto;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class MemberMissionQueryServiceImpl implements MemberMissionQueryService {
    private final MemberMissionRepositoryImpl memberMissionRepository;

    @Override
    public List<MemberMissionIsCompletedResponseDto> getCompletedAndInProgressMission(Long memberId, MissionStatus status, int page) {
        List<MemberMissionIsCompletedResponseDto> memberMissions = memberMissionRepository.findByMemberIdAndMissionStatus(memberId, status, page);
        return memberMissions;
    }

    @Override
    public List<MemberMissionByLocationResponseDto> getMissionByLocal(Long memberId, String location, int page) {
        List<MemberMissionByLocationResponseDto> memberMissionsByLocation = memberMissionRepository.findByMemberIdAndMissionLocation(memberId, location, page);
        return memberMissionsByLocation;
    }

    @Override
    public Long getCompletedMissionCount(Long memberId) {
        return memberMissionRepository.countByMemberId(memberId);
    }
}
