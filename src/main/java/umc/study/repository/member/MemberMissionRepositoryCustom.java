package umc.study.repository.member;

import umc.study.domain.enums.MissionStatus;
import umc.study.repository.member.dto.MemberMissionByLocationResponseDto;
import umc.study.repository.member.dto.MemberMissionIsCompletedResponseDto;

import java.util.List;

public interface MemberMissionRepositoryCustom {
    List<MemberMissionIsCompletedResponseDto> findByMemberIdAndMissionStatus(Long memberId, MissionStatus status, int page);

    List<MemberMissionByLocationResponseDto> findByMemberIdAndMissionLocation(Long memberId, String location, int page);

    Long countByMemberId(Long memberId);
}
