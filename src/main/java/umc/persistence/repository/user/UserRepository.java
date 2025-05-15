package umc.persistence.repository.user;


import umc.presentation.dto.user.UserResponse;

public interface UserRepository {
    UserResponse.UserProfileDto getUserProfile(Long userId);
}
