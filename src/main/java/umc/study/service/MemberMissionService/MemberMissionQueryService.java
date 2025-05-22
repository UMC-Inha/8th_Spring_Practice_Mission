package umc.study.service.MemberMissionService;

public interface MemberMissionQueryService {
    boolean isAlreadyChallenged(Long memberId, Long missionId);
}
