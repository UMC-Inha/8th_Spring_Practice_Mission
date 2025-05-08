package umc.presentation.dto.user;


public record UserProfileDto(String email,
                             String name,
                             Integer point,
                             String phoneVerified) { }
