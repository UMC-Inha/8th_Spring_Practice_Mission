package umc.dto;

public record MissionDto(
	Long missionId,
	String restaurantName,
	String content,
	Integer point
) {}
