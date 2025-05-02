package umc.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import umc.repository.AgreeSetRepository;

@Service
@RequiredArgsConstructor
public class AgreeSetService {

    private final AgreeSetRepository agreeSetRepository;

    @Transactional
    public void deleteAgreeSetByMember(Long memberId) {

        agreeSetRepository.deleteAllByMemberId(memberId);
    }
}
