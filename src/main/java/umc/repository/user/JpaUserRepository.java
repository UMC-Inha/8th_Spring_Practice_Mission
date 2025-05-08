package umc.repository.user;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import umc.entity.user.User;

@Repository
public interface JpaUserRepository extends JpaRepository<User, Long> {
}
