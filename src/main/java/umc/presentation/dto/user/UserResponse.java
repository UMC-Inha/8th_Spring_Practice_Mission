package umc.presentation.dto.user;

public class UserResponse {
    public record UserProfileDto(String email,
                              String name,
                              Integer point,
                              String phoneVerified) { }
}
