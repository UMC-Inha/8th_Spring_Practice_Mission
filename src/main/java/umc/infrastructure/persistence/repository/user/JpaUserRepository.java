package umc.infrastructure.persistence.repository.user;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import umc.infrastructure.persistence.entity.user.User;

@Repository
public interface JpaUserRepository extends JpaRepository<User, Long> {
}
