package umc.study.repository.member;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import umc.study.domain.enums.MissionStatus;
import umc.study.repository.member.dto.MemberMissionByLocationResponseDto;
import umc.study.repository.member.dto.MemberMissionIsCompletedResponseDto;

import java.util.List;

public interface MemberMissionRepositoryCustom {
    Page<MemberMissionIsCompletedResponseDto> findByMemberIdAndMissionStatus(Long memberId, MissionStatus status, Pageable pageable);

    List<MemberMissionByLocationResponseDto> findByMemberIdAndMissionLocation(Long memberId, String location, int page);

    Long countByMemberId(Long memberId);
}
