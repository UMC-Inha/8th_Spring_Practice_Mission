package umc.UMC8th.service;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import umc.UMC8th.converter.MemberConverter;
import umc.UMC8th.domain.Member;
import umc.UMC8th.dto.MemberRequestDTO;
import umc.UMC8th.repository.MemberRepository;

@Service
@RequiredArgsConstructor
public class MemberCommandServiceImpl implements MemberCommandService {

    private final MemberRepository memberRepository;

    @Override
    @Transactional
    public Member joinMember(MemberRequestDTO.JoinDto request) {
        Member newMember = MemberConverter.toMember(request);
        return memberRepository.save(newMember);
    }
}
