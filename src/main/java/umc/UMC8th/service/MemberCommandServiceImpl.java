package umc.UMC8th.service;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import umc.UMC8th.apiPayload.code.status.ErrorStatus;
import umc.UMC8th.converter.MemberConverter;
import umc.UMC8th.converter.MemberPreferConverter;
import umc.UMC8th.domain.FoodCategories;
import umc.UMC8th.domain.Member;
import umc.UMC8th.domain.mapping.MemberPrefer;
import umc.UMC8th.dto.MemberRequestDTO;
import umc.UMC8th.exception.handler.FoodCategoryHandler;
import umc.UMC8th.repository.FoodCategoryRepository;
import umc.UMC8th.repository.MemberRepository;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class MemberCommandServiceImpl implements MemberCommandService {

    private final MemberRepository memberRepository;
    private final FoodCategoryRepository foodCategoryRepository;

    @Override
    @Transactional
    public Member joinMember(MemberRequestDTO.JoinDto request) {
        Member newMember = MemberConverter.toMember(request);

        List<FoodCategories> foodCategoryList = request.getFoodCategories().stream()
                .map(categoryId -> foodCategoryRepository.findById(categoryId)
                        .orElseThrow(() -> new FoodCategoryHandler(ErrorStatus.FOOD_CATEGORY_NOT_FOUND)))
                .collect(Collectors.toList());

        List<MemberPrefer> memberPreferList = MemberPreferConverter.toMemberPreferList(foodCategoryList);

        memberPreferList.forEach(prefer -> prefer.setMember(newMember));
        newMember.getMemberPrefers().addAll(memberPreferList);

        return memberRepository.save(newMember);
    }
}
