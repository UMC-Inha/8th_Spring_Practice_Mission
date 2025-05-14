package umc.study.service.UserMissionService;

import umc.study.domain.mapping.UserMission;

import java.util.List;
import java.util.Optional;

public interface UserMissionQueryService {
    Optional<UserMission> findByMemberId(Long memberId);
    List<UserMission> findAllByMemberId(Long memberId);
}
