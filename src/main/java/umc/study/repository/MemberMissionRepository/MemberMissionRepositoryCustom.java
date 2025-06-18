package umc.study.repository.MemberMissionRepository;

import umc.study.domain.enums.MissionStatus;
import umc.study.web.dto.response.MemberMissionResponseDTO;

import java.time.LocalDateTime;
import java.util.List;

public interface MemberMissionRepositoryCustom {
    public List<MemberMissionResponseDTO.MyMemberMissionDTO> findMyMissionsDTOByCursor(
            Long memberId,
            MissionStatus status,
            Long cursorId,
            LocalDateTime cursorCreatedAt,
            Integer size
    );
}
