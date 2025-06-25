package umc.infrastructure.persistence.repository.user;


import umc.infrastructure.persistence.entity.user.User;

import java.util.Optional;

public interface UserRepository {
    User save(User user);

    Optional<User> findById(Long id);

    boolean existsById(Long id);

    Optional<User> findByEmail(String email);
}
