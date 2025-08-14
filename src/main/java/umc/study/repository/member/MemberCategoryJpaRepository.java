package umc.study.repository.member;

import org.springframework.data.jpa.repository.JpaRepository;
import umc.study.domain.mapping.MemberCategory;

public interface MemberCategoryJpaRepository extends JpaRepository<MemberCategory, Long> {
}
