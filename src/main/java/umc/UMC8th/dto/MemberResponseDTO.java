package umc.UMC8th.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

public class MemberResponseDTO {

    @Getter
    @Builder
    @NoArgsConstructor
    @AllArgsConstructor
    public static class JoinResultDto {
        private Long userId;
        private String email;
        private String nickname;
        private LocalDate userBirth;
        private String userAddress;
        private String foodCategories;
        private LocalDateTime createdAt;
    }

    @Builder
    @Getter
    @NoArgsConstructor
    @AllArgsConstructor
    public static class MyReviewListDTO {
        List<MyReviewDTO> reviewList;
        Integer listSize;
        Integer totalPage;
        Long totalElements;
        Boolean isFirst;
        Boolean isLast;
    }

    @Builder
    @Getter
    @NoArgsConstructor
    @AllArgsConstructor
    public static class MyReviewDTO {
        String storeName;
        Float rating;
        String content;
        LocalDate createdAt;
    }

    @Getter
    @Builder
    @AllArgsConstructor
    @NoArgsConstructor
    public static class MissionPreviewDTO {
        private String title;
        private String explanation;
        private LocalDate deadline;
        private String storeName;
    }

    @Getter
    @Builder
    @AllArgsConstructor
    @NoArgsConstructor
    public static class MissionPreviewListDTO {
        private boolean isFirst;
        private boolean isLast;
        private int totalPage;
        private long totalElements;
        private int listSize;
        private List<MissionPreviewDTO> missionList;
    }
}
