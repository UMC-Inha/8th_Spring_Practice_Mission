package umc.study.service.member;

import umc.study.domain.member.Member;
import umc.study.web.controller.member.dto.MemberRequestDTO.JoinDto;

public interface MemberCommandService {
    Member joinMember(JoinDto request);
}
