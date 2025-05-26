package umc.study.repository.MemberRepository;

import org.springframework.data.jpa.repository.JpaRepository;
import umc.study.domain.mapping.MemberMission;

public interface MemberMissionRepository extends JpaRepository<MemberMission, Long>, MemberMissionRepositoryCustom {

    boolean existsByMemberIdAndMissionId(Long memberId, Long missionId);
}
