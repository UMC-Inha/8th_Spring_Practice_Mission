package umc.repository.member;

import org.springframework.data.jpa.repository.JpaRepository;
import umc.domain.Member;

import java.util.Optional;

public interface MemberRepository extends JpaRepository<Member, Long> {

    Optional<Member> findByMail(String mail);
}
