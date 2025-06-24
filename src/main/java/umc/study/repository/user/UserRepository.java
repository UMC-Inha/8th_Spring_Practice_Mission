package umc.study.repository.user;

import org.springframework.data.jpa.repository.JpaRepository;
import umc.study.domain.user.User;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByEmail(String email);
}
