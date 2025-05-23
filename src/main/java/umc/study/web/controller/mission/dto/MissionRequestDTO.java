package umc.study.web.controller.mission.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import umc.study.domain.enums.MissionStatus;
import umc.study.repository.member.MemberJpaRepository;
import umc.study.repository.mission.MissionRepository;
import umc.study.repository.store.StoreRepository;
import umc.study.validation.annotation.ExistsInDb;

import java.time.LocalDateTime;

public class MissionRequestDTO {
    @Getter
    @AllArgsConstructor
    @NoArgsConstructor
    @Builder
    public static class AddMission{
        @ExistsInDb(
                message = "해당 가게가 존재하지 않습니다.",
                repository = StoreRepository.class
        )
        private Long storeId;

        @NotBlank
        private String missionSpec;

        @NotBlank
        private String local;

        @NotBlank
        private LocalDateTime deadline;
    }

    @Getter
    @AllArgsConstructor
    @NoArgsConstructor
    @Builder
    public static class AddMemberMission{
        @ExistsInDb(
                message = "해당 미션이 존재하지 않습니다.",
                repository = MissionRepository.class
        )
        private Long missionId;

        @ExistsInDb(
                message = "해당 회원이 존재하지 않습니다.",
                repository = MemberJpaRepository.class
        )
        private Long memberId;

        private MissionStatus missionStatus = MissionStatus.IN_PROGRESS;
    }

}
