package umc.study.service.member;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import umc.study.domain.enums.MissionStatus;
import umc.study.repository.member.MemberMissionRepositoryImpl;
import umc.study.repository.member.dto.MemberMissionByLocationResponseDto;
import umc.study.repository.member.dto.MemberMissionIsCompletedResponseDto;
import umc.study.web.controller.mission.dto.MemberMissionResponseDTO;
import umc.study.web.converter.mission.MemberMissionConverter;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class MemberMissionQueryServiceImpl implements MemberMissionQueryService {
    private final MemberMissionRepositoryImpl memberMissionRepository;

    @Override
    public Page<MemberMissionResponseDTO.MissionInProgressDTO> getCompletedAndInProgressMission(Long memberId, MissionStatus status, Pageable pageable) {
        Page<MemberMissionIsCompletedResponseDto> memberMissions = memberMissionRepository.findByMemberIdAndMissionStatus(memberId, status, pageable);
        return memberMissions.map(mm -> MemberMissionResponseDTO.MissionInProgressDTO.builder()
                .missionSpec(mm.getMissionSpec())
                .storeName(mm.getStoreName())
                .point(mm.getPoint())
                .status(MissionStatus.IN_PROGRESS)
                .build());
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
