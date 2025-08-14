package umc.study.service.member;

import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import umc.study.domain.member.Member;
import umc.study.repository.member.MemberJpaRepository;
import umc.study.repository.member.PointMemberRepositoryImpl;
import umc.study.repository.member.dto.MemberInfoResponseDto;
import umc.study.web.controller.member.dto.MemberResponseDTO;
import umc.study.web.controller.member.dto.MemberResponseDTO.MemberInfoDTO;
import umc.study.web.converter.member.MemberConverter;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class MemberQueryServiceImpl implements MemberQueryService{
    private final PointMemberRepositoryImpl pointMemberRepository;
    private final MemberJpaRepository memberJpaRepository;
    private final umc.study.config.security.jwt.JwtTokenProvider jwtTokenProvider;

    @Override
    public MemberInfoResponseDto getMemberInfo(Long memberId) {
        return pointMemberRepository.findByMemberId(memberId);
    }

    @Override
    @Transactional(readOnly = true)
    public MemberInfoDTO getMemberInfo(HttpServletRequest request){
        Authentication authentication = jwtTokenProvider.extractAuthentication(request);
        String email = authentication.getName();

        Member member = memberJpaRepository.findByEmail(email)
                .orElseThrow(() -> new umc.study.apiPayload.exception.GeneralException(umc.study.apiPayload.code.status.ErrorStatus.MEMBER_NOT_FOUND));
        return MemberConverter.toMemberInfoDTO(member);
    }
}
