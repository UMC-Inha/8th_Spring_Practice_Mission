package umc.study.web.dto.Member;

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
