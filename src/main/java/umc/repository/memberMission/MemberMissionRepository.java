package umc.repository.memberMission;

import org.springframework.data.jpa.repository.JpaRepository;
import umc.domain.mapping.MemberMission;

public interface MemberMissionRepository extends JpaRepository<MemberMission, Long> {
    void deleteAllByMemberId(Long memberId);
}
