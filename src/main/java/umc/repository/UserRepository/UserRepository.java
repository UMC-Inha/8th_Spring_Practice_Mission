package umc.repository.UserRepository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import umc.domain.User;

public interface UserRepository extends JpaRepository<User, Long>, UserRepositoryCustom {
	Optional<User> findByEmail(String email);
	boolean existsByEmail(String email);
}
