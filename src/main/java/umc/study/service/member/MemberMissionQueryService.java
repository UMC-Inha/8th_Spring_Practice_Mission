package umc.study.service.member;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import umc.study.domain.enums.MissionStatus;
import umc.study.repository.member.dto.MemberMissionByLocationResponseDto;
import umc.study.repository.member.dto.MemberMissionIsCompletedResponseDto;
import umc.study.web.controller.mission.dto.MemberMissionResponseDTO;

import java.util.List;

public interface MemberMissionQueryService {
    Page<MemberMissionResponseDTO.MissionInProgressDTO> getCompletedAndInProgressMission(Long memberId, MissionStatus status, Pageable pageable);

    List<MemberMissionByLocationResponseDto> getMissionByLocal(Long memberId, String location, int page);

    Long getCompletedMissionCount(Long memberId);
}
