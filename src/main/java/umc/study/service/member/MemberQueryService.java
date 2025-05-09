package umc.study.service.member;

import umc.study.repository.member.dto.MemberInfoResponseDto;

public interface MemberQueryService {
    public MemberInfoResponseDto getMemberInfo(Long memberId);
}
