package umc.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import umc.domain.Member;
import umc.repository.*;

@Service
@RequiredArgsConstructor
public class MemberService {

    private final MemberRepository memberRepository;

    private final AlarmService alarmService;
    private final QnaService qnaService;
    private final AgreeSetService agreeSetService;
    private final MemberMissionService memberMissionService;
    private final PreferCategoryService preferCategoryService;
    private final ReviewService reviewService;

    @Transactional
    public void deleteMember(Long memberId) {
        Member member = memberRepository.findById(memberId)
                .orElseThrow(() -> new RuntimeException("Member Not Found"));

        qnaService.deleteQnaByMember(memberId);
        alarmService.deleteAlarmByMember(memberId);
        agreeSetService.deleteAgreeSetByMember(memberId);
        memberMissionService.deleteMemberMissionByMember(memberId);
        preferCategoryService.deletePreferCategoryByMember(memberId);
        reviewService.deleteReviewByMember(memberId);

        member.updateStatus();

        memberRepository.save(member);
    }
}
