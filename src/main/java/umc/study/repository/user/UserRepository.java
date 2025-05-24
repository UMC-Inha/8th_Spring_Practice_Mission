package umc.study.repository.user;

import org.springframework.data.jpa.repository.JpaRepository;
import umc.study.domain.user.User;

public interface UserRepository extends JpaRepository<User, Long> {
}
