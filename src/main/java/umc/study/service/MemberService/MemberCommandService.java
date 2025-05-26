package umc.study.service.MemberService;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import umc.study.domain.Member;
import umc.study.web.dto.Member.MemberRequestDTO;
import umc.study.web.dto.Mission.MemberMissionResponseDto;

public interface MemberCommandService {

    Member joinMember(MemberRequestDTO.JoinDto request);

    Page<MemberMissionResponseDto.JoinResultDTO> findMemberMissions(Long memberId, Pageable pageable);
}
