package umc.UMC8th.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import umc.UMC8th.domain.Member;

import java.util.Optional;

public interface MemberRepository extends JpaRepository<Member, Long> {
    Optional<Member> findByEmail(String email);
}
