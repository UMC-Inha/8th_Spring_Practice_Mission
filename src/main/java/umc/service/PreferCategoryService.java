package umc.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import umc.repository.PreferCategoryRepository;

@Service
@RequiredArgsConstructor
public class PreferCategoryService {

    private final PreferCategoryRepository preferCategoryRepository;

    @Transactional
    public void deletePreferCategoryByMember(Long memberId) {

        preferCategoryRepository.deleteAllByMemberId(memberId);
    }
}
