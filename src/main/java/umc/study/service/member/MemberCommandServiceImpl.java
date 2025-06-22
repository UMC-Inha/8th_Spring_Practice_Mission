package umc.study.service.member;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import umc.study.apiPayload.code.status.ErrorStatus;
import umc.study.apiPayload.exception.GeneralException;
import umc.study.domain.category.Category;
import umc.study.domain.mapping.MemberCategory;
import umc.study.domain.member.Member;
import umc.study.repository.food.CategoryRepository;
import umc.study.repository.member.MemberCategoryJpaRepository;
import umc.study.repository.member.MemberJpaRepository;
import umc.study.web.controller.member.dto.MemberRequestDTO.JoinDto;
import umc.study.web.converter.member.MemberConverter;
import umc.study.web.converter.member.MemberPreferConverter;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class MemberCommandServiceImpl implements MemberCommandService{
    private final MemberJpaRepository memberJpaRepository;
    private final CategoryRepository categoryRepository;
    private final MemberCategoryJpaRepository memberCategoryJpaRepository;
    private final PasswordEncoder passwordEncoder;

    @Transactional
    @Override
    public Member joinMember(JoinDto request) {
        Member member = MemberConverter.toMember(request);
        List<Category> foodCateogoryList = categoryRepository.findAllById(request.getPreferCategories());
        if (foodCateogoryList.size() != request.getPreferCategories().size()) {
            throw new GeneralException(ErrorStatus.FOOD_CATEGORY_NOT_FOUND);
        }
        member.encodePassword(passwordEncoder.encode(request.getPassword()));
        Member saveMember = memberJpaRepository.save(member);
        List<MemberCategory> memberCategoryList = MemberPreferConverter.toMemberPreferList(member, foodCateogoryList);
        memberCategoryJpaRepository.saveAll(memberCategoryList);
        //트랜잭션 커밋 이후에 saveMember 컨트롤러로 반환
        return saveMember;
    }
}
