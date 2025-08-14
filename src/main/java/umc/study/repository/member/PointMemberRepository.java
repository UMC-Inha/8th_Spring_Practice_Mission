package umc.study.repository.member;

import org.springframework.data.jpa.repository.JpaRepository;
import umc.study.domain.mapping.PointMember;

public interface PointMemberRepository extends JpaRepository<PointMember, Long> {
}
