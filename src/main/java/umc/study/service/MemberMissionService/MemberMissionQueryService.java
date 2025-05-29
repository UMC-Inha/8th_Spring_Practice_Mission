package umc.study.service.MemberMissionService;

import org.springframework.data.domain.Page;
import umc.study.domain.mapping.MemberMission;

public interface MemberMissionQueryService {
    boolean isAlreadyChallenged(Long memberId, Long missionId);
    Page<MemberMission> getMemberMissionList(Long memberId, Integer page);
}
