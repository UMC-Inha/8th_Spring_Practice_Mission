package umc.service.member;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import umc.apiPayload.code.status.ErrorStatus;
import umc.apiPayload.exception.handler.FoodCategoryHandler;
import umc.converter.member.MemberConverter;
import umc.converter.preferCategory.PreferCategoryConverter;
import umc.domain.FoodCategory;
import umc.domain.Member;
import umc.domain.mapping.PreferCategory;
import umc.dto.member.MemberRequestDTO;
import umc.repository.PreferCategoryRepository;
import umc.repository.foodCategory.FoodCategoryRepository;
import umc.repository.member.MemberRepository;
import umc.service.*;
import umc.service.memberMission.MemberMissionService;
import umc.service.review.ReviewService;

import java.util.List;

@Service
@RequiredArgsConstructor
public class MemberService {

    private final MemberRepository memberRepository;
    private final FoodCategoryRepository foodCategoryRepository;
    private final PreferCategoryRepository preferCategoryRepository;

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

    @Transactional
    public Member joinMember(MemberRequestDTO.JoinDto request) {

        Member newMember = MemberConverter.toMember(request);

        List<FoodCategory> foodCategoryList = request.getPreferCategory().stream()
                .map(categoryId -> {
                    return foodCategoryRepository.findById(categoryId)
                            .orElseThrow(() -> new FoodCategoryHandler(ErrorStatus.FOOD_CATEGORY_NOT_FOUND));
                }).toList();

        List<PreferCategory> preferCategoryList = PreferCategoryConverter.toPreferCategoryList(newMember, foodCategoryList);

        memberRepository.save(newMember);
        preferCategoryRepository.saveAll(preferCategoryList);

        return newMember;
    }
}
