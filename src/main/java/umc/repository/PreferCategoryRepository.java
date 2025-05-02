package umc.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import umc.domain.mapping.PreferCategory;

public interface PreferCategoryRepository extends JpaRepository<PreferCategory, Long> {
    void deleteAllByMemberId(Long memberId);
}
