package umc.persistence.repository.user;

import umc.presentation.dto.user.UserProfileDto;

public interface UserRepository {
    UserProfileDto getUserProfile(Long userId);
}
