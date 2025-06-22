package umc.study.service.member;

import jakarta.servlet.http.HttpServletRequest;
import umc.study.domain.member.Member;
import umc.study.web.controller.member.dto.MemberRequestDTO;
import umc.study.web.controller.member.dto.MemberRequestDTO.JoinDto;
import umc.study.web.controller.member.dto.MemberResponseDTO;

import static umc.study.web.controller.member.dto.MemberRequestDTO.*;
import static umc.study.web.controller.member.dto.MemberResponseDTO.*;

public interface MemberCommandService {
    Member joinMember(JoinDto request);
    LoginResultDTO loginMember(LoginRequestDTO request);
}
