package umc.spring.service.memberService;

import jakarta.persistence.Converter;
import jakarta.servlet.http.HttpServletRequest;
import umc.spring.web.dto.member.MemberResponseDTO;

public interface MemberQueryService {
    MemberResponseDTO.MemberInfoDTO getMemberInfo(HttpServletRequest request);
}
