package umc.study.service.member;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import umc.study.repository.member.PointMemberRepositoryImpl;
import umc.study.repository.member.dto.MemberInfoResponseDto;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class MemberQueryServiceImpl implements MemberQueryService{
    private final PointMemberRepositoryImpl pointMemberRepository;

    @Override
    public MemberInfoResponseDto getMemberInfo(Long memberId) {
        return pointMemberRepository.findByMemberId(memberId);
    }
}
