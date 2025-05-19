package umc.study.web.dto;

import java.time.LocalDate;

public record MemberMissionDto(
        Long missionId,
        String missionSpec,
        Integer reward,
        LocalDate deadline,
        String storeName,
        String status
) {
}
