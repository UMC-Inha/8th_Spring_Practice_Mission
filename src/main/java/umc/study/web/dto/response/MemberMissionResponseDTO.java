package umc.study.web.dto.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import umc.study.domain.enums.MissionStatus;

import java.time.LocalDateTime;
import java.util.List;

public class MemberMissionResponseDTO {
    @Getter
    @Builder
    @NoArgsConstructor
    @AllArgsConstructor
    public static class challengeResultDTO {
        Long memberMissionId;
        LocalDateTime createdAt;
    }

    @Getter
    @Builder
    @NoArgsConstructor
    @AllArgsConstructor
    public static class MyMemberMissionDTO {
        Long memberMissionId;
        String storeName;
        String missionSpec;
        Integer reward;
        MissionStatus missionStatus;
        LocalDateTime createdAt;
    }

    @Getter
    @Builder
    @NoArgsConstructor
    @AllArgsConstructor
    public static class MyMemberMissionSliceDTO {
        List<MyMemberMissionDTO> memberMissionList;
        Long cursorId; //현재 조회한 마지막 memberMission의 id
        LocalDateTime cursorCreatedAt; //현재 조회한 마지막 memberMission의 createdAt
        private boolean hasNext;
    }
}
