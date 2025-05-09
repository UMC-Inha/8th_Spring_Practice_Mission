package umc.study.service.member;

import umc.study.domain.enums.MissionStatus;
import umc.study.repository.member.dto.MemberMissionByLocationResponseDto;
import umc.study.repository.member.dto.MemberMissionIsCompletedResponseDto;

import java.util.List;

public interface MemberMissionQueryService {
    List<MemberMissionIsCompletedResponseDto> getCompletedAndInProgressMission(Long memberId, MissionStatus status, int page);

    List<MemberMissionByLocationResponseDto> getMissionByLocal(Long memberId, String location, int page);

    Long getCompletedMissionCount(Long memberId);
}
