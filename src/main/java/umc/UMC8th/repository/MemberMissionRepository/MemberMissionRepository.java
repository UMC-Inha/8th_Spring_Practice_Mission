package umc.UMC8th.repository.MemberMissionRepository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import umc.UMC8th.domain.Member;
import umc.UMC8th.domain.enums.MissionStatus;
import umc.UMC8th.domain.mapping.MemberMission;

public interface MemberMissionRepository extends JpaRepository<MemberMission, Long>, MemberMissionRepositoryCustom {
    boolean existsByMemberIdAndMissionId(Long memberId, Long missionId); // 쿼리 메서드 자동 생성 추가
    Page<MemberMission> findAllByMemberAndStatus (Member member, MissionStatus status, Pageable pageable);
}
