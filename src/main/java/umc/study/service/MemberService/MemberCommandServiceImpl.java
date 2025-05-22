package umc.study.service.MemberService;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import umc.study.apiPayload.code.status.ErrorStatus;
import umc.study.apiPayload.exception.handler.FoodTypeHandler;
import umc.study.converter.MemberConverter;
import umc.study.converter.MemberPreferConverter;
import umc.study.domain.FoodType;
import umc.study.domain.Member;
import umc.study.domain.mapping.MemberPrefer;
import umc.study.repository.FoodTypeRepository;
import umc.study.repository.MemberRepository;
import umc.study.web.dto.request.MemberRequestDTO;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class MemberCommandServiceImpl implements MemberCommandService {

    private final MemberRepository memberRepository;

    private final FoodTypeRepository foodTypeRepository;

    @Override
    @Transactional
    public Member joinMember(MemberRequestDTO.JoinDto request) {

        Member newMember = MemberConverter.toMember(request);
        List<FoodType> foodtypeList = request.getPreferCategory().stream()
                .map(category -> {
                    return foodTypeRepository.findById(category).orElseThrow(() -> new FoodTypeHandler(ErrorStatus.FOOD_TYPE_NOT_FOUND));
                }).collect(Collectors.toList());

        List<MemberPrefer> memberPreferList = MemberPreferConverter.toMemberPreferList(foodtypeList);

        memberPreferList.forEach(memberPrefer -> {
            memberPrefer.setMember(newMember);
        });

        return memberRepository.save(newMember);
    }
}