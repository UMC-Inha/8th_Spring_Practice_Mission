package umc.study.repository.member;

import org.springframework.data.jpa.repository.JpaRepository;
import umc.study.domain.member.Member;

import java.util.Optional;

public interface MemberJpaRepository extends JpaRepository<Member, Long> {
    Optional<Member> findByEmail(String email);
}
