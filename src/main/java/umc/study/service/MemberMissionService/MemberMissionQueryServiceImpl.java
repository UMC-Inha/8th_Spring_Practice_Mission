package umc.study.service.MemberMissionService;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import umc.study.domain.enums.MissionStatus;
import umc.study.repository.MemberMissionRepository.MemberMissionRepository;
import umc.study.web.dto.response.MemberMissionResponseDTO;

import java.time.LocalDateTime;
import java.util.List;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class MemberMissionQueryServiceImpl implements MemberMissionQueryService {
    private final MemberMissionRepository memberMissionRepository;

    @Override
    public List<MemberMissionResponseDTO.MyMemberMissionDTO> getMyMissionsByCursor(Long memberId, MissionStatus status, Long cursorId, LocalDateTime cursorCreatedAt, Integer size) {
        return memberMissionRepository.findMyMissionsDTOByCursor(memberId, status, cursorId, cursorCreatedAt, size + 1); //다음 데이터가 존재하는지 확인하기 위해 하나 더 가져옴
    }
}
