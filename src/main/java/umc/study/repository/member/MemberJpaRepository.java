package umc.study.repository.member;

import org.springframework.data.jpa.repository.JpaRepository;
import umc.study.domain.member.Member;

public interface MemberJpaRepository extends JpaRepository<Member, Long> {
}
