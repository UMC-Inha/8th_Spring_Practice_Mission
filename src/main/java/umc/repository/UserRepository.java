package umc.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import umc.domain.User;

public interface UserRepository extends JpaRepository<User, Long> {
}
