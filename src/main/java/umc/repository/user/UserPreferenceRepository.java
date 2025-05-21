package umc.repository.user;

import org.springframework.data.jpa.repository.JpaRepository;
import umc.domain.User;
import umc.domain.mapping.UserPreference;

public interface UserPreferenceRepository extends JpaRepository<UserPreference, Long> {
}
