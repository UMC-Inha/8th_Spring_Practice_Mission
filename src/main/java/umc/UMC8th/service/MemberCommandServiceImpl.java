package umc.UMC8th.service;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import umc.UMC8th.apiPayload.code.status.ErrorStatus;
import umc.UMC8th.config.security.jwt.JwtTokenProvider;
import umc.UMC8th.converter.MemberConverter;
import umc.UMC8th.converter.MemberPreferConverter;
import umc.UMC8th.domain.FoodCategories;
import umc.UMC8th.domain.Member;
import umc.UMC8th.domain.mapping.MemberPrefer;
import umc.UMC8th.dto.MemberRequestDTO;
import umc.UMC8th.dto.MemberResponseDTO;
import umc.UMC8th.exception.handler.FoodCategoryHandler;
import umc.UMC8th.exception.handler.MemberHandler;
import umc.UMC8th.repository.FoodCategoryRepository;
import umc.UMC8th.repository.MemberRepository;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class MemberCommandServiceImpl implements MemberCommandService {

    private final MemberRepository memberRepository;
    private final FoodCategoryRepository foodCategoryRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtTokenProvider jwtTokenProvider;

    @Override
    @Transactional
    public Member joinMember(MemberRequestDTO.JoinDto request) {
        System.out.println("joinMember 호출됨: " + request.getEmail());
        Member newMember = MemberConverter.toMember(request);
        newMember.encodePassword(passwordEncoder.encode(request.getPassword())); // 비밀번호 암호화

        List<FoodCategories> foodCategoryList = request.getPreferCategory().stream()
                .map(categoryId -> foodCategoryRepository.findById(categoryId)
                        .orElseThrow(() -> new FoodCategoryHandler(ErrorStatus.FOOD_CATEGORY_NOT_FOUND)))
                .collect(Collectors.toList());

        List<MemberPrefer> memberPreferList = MemberPreferConverter.toMemberPreferList(foodCategoryList);

        memberPreferList.forEach(prefer -> prefer.setMember(newMember));
        newMember.getMemberPrefers().addAll(memberPreferList);

        return memberRepository.save(newMember);
    }

    @Override
    @Transactional
    public MemberResponseDTO.LoginResultDTO loginMember(MemberRequestDTO.LoginRequestDTO request) {
        Member member = memberRepository.findByEmail(request.getEmail())
                .orElseThrow(()-> new MemberHandler(ErrorStatus.MEMBER_NOT_FOUND));

        if(!passwordEncoder.matches(request.getPassword(), member.getPassword())) {
            throw new MemberHandler(ErrorStatus.INVALID_PASSWORD);
        }

        Authentication authentication = new UsernamePasswordAuthenticationToken(
                member.getEmail(), null,
                Collections.singleton(() -> member.getRole().name())
        );

        String accessToken = jwtTokenProvider.generateToken(authentication);

        return MemberConverter.toLoginResultDTO(
                member.getId(),
                accessToken
        );
    }
}
