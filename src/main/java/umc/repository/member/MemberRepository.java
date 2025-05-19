package umc.repository.member;

import org.springframework.data.jpa.repository.JpaRepository;
import umc.domain.Member;

public interface MemberRepository extends JpaRepository<Member, Long> {
}
