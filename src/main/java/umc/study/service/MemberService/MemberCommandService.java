package umc.study.service.MemberService;

import umc.study.domain.Member;
import umc.study.web.dto.MemberDTO.MemberRequestDTO;
import umc.study.web.dto.MemberDTO.MemberResponseDTO;

public interface MemberCommandService {
    Member joinMember(MemberRequestDTO.JoinDTO request);
    MemberResponseDTO.LoginResultDTO loginMember(MemberRequestDTO.LoginRequestDTO request);
}
