package umc.presentation.dto.mission;

public class MissionResponse {
    public record MissionCardDto(String storeName,
                                        String storeCategoryName,
                                        String content,
                                        int    point,
                                        long   dDay) { }
}
