package umc.dto;

public record MyPageDto(
	Long userId,
	String userName,
	String email,
	Long point,
	String profileImageUrl,
	String phoneNumber
) {}
