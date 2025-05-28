package umc.study.service.MemberMissionService;

import umc.study.domain.enums.MissionStatus;
import umc.study.web.dto.response.MemberMissionResponseDTO;

import java.time.LocalDateTime;
import java.util.List;

public interface MemberMissionQueryService {
    public List<MemberMissionResponseDTO.MyMemberMissionDTO> getMyMissionsByCursor(
            Long memberId,
            MissionStatus status,
            Long cursorId,
            LocalDateTime cursorCreatedAt,
            Integer size
    );
}
