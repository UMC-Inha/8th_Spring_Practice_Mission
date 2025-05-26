package umc.study.repository.MemberRepository;

import umc.study.web.dto.Member.MemberDetailResponseDto;

public interface MemberRepositoryCustom {

    MemberDetailResponseDto findMemberDetail(Long memberId);
}
