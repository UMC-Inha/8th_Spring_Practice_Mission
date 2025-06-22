package umc.study.repository.UserRepository;

import org.springframework.data.jpa.repository.JpaRepository;
import umc.study.domain.User;
import umc.study.repository.UserMissionRepository.UserMissionRepositoryCustom;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> , UserRepositoryCustom{
    Optional<User> findByEmail(String email);
}
