package umc.UMC8th.repository.MemberMissionRepository;

import umc.UMC8th.dto.MemberMissionResponse;

import java.util.List;

public interface MemberMissionRepositoryCustom {
    List<MemberMissionResponse> findMissionsByMemberId(Long memberId, int offset, int limit);
}
