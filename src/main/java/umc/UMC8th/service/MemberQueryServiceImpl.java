package umc.UMC8th.service;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.security.core.Authentication;
import org.springframework.transaction.annotation.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import umc.UMC8th.apiPayload.code.status.ErrorStatus;
import umc.UMC8th.config.security.jwt.JwtTokenProvider;
import umc.UMC8th.domain.Member;
import umc.UMC8th.domain.Review;
import umc.UMC8th.domain.mapping.MemberMission;
import umc.UMC8th.dto.MemberResponseDTO;
import umc.UMC8th.exception.handler.MemberHandler;
import umc.UMC8th.repository.MemberMissionRepository.MemberMissionRepository;
import umc.UMC8th.repository.MemberRepository;
import umc.UMC8th.repository.ReviewRepository;
import umc.UMC8th.domain.enums.MissionStatus;
import umc.UMC8th.converter.MemberConverter;


@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class MemberQueryServiceImpl implements MemberQueryService {

    private final MemberRepository memberRepository;
    private final ReviewRepository reviewRepository;
    private final MemberMissionRepository memberMissionRepository;
    private final JwtTokenProvider jwtTokenProvider;

    @Override
    public Page<Review> getMyReviews(Long memberId, int page) {
        Member member = memberRepository.findById(memberId)
                .orElseThrow(() -> new IllegalArgumentException("존재하지 않는 회원입니다."));
        return reviewRepository.findAllByMember(member, PageRequest.of(page, 10));
    }

    @Override
    public Page<MemberMission> getOngoingMissions(Long memberId, int page) {
        Member member = memberRepository.findById(memberId)
                .orElseThrow(() -> new IllegalArgumentException("해당 회원이 존재하지 않습니다."));
        return memberMissionRepository.findAllByMemberAndStatus(member, MissionStatus.CHALLENGING, PageRequest.of(page, 10));
    }

    @Override
    @Transactional(readOnly = true)
    public MemberResponseDTO.MemberInfoDTO getMemberInfo(HttpServletRequest request){
        Authentication authentication = jwtTokenProvider.extractAuthentication(request);
        String email = authentication.getName();

        Member member = memberRepository.findByEmail(email)
                .orElseThrow(()-> new MemberHandler(ErrorStatus.MEMBER_NOT_FOUND));
        return MemberConverter.toMemberInfoDTO(member);
    }
}
