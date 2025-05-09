package umc.study.repository.member;

import umc.study.repository.member.dto.MemberInfoResponseDto;

public interface PointMemberRepositoryCustom {
    MemberInfoResponseDto findByMemberId(Long memberId);
}
