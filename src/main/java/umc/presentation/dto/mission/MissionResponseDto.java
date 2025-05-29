package umc.presentation.dto.mission;

import lombok.Builder;

import java.time.LocalDateTime;
import java.util.List;

public class MissionResponseDto {
    @Builder
    public record MissionCreateResponseDto(Long missionId,
                                           String content,
                                           LocalDateTime dueDate,
                                           LocalDateTime createdAt) { }

    @Builder
    public record AddMissionToUserResponseDto(Long userId, Long missionId) { }

    @Builder
    public record MissionPreviewDto( String content,
                                    String storeName,
                                    Integer point,
                                    LocalDateTime dueDate,
                                    LocalDateTime createdAt){}

    @Builder
    public record MissionPreviewListDto(List<MissionPreviewDto> missionList,
                                        Integer listSize,
                                        Integer totalPage,
                                        Long totalElements,
                                        Boolean isFirst,
                                        Boolean isLast){}
}
