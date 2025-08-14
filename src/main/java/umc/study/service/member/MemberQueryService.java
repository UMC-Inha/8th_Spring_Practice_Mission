package umc.study.service.member;

import jakarta.servlet.http.HttpServletRequest;
import umc.study.repository.member.dto.MemberInfoResponseDto;
import umc.study.web.controller.member.dto.MemberResponseDTO;

import static umc.study.web.controller.member.dto.MemberResponseDTO.*;

public interface MemberQueryService {
    public MemberInfoResponseDto getMemberInfo(Long memberId);
    MemberInfoDTO getMemberInfo(HttpServletRequest request);
}
