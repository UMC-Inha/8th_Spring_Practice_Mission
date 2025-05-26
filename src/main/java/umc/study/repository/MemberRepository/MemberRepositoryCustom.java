package umc.study.repository.MemberRepository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import umc.study.domain.enums.MissionStatus;
import umc.study.domain.mapping.MemberMission;
import umc.study.web.dto.Member.MemberDetailResponseDto;

public interface MemberRepositoryCustom {

    MemberDetailResponseDto findMemberDetail(Long memberId);

    Page<MemberMission> findMissionsByMember(
            Long memberId,
            MissionStatus status,
            Pageable pageable
    );
}
