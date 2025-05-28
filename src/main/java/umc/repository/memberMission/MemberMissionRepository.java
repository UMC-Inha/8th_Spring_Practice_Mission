package umc.repository.memberMission;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.repository.JpaRepository;
import umc.domain.Member;
import umc.domain.Mission;
import umc.domain.enums.MissionStatus;
import umc.domain.mapping.MemberMission;

public interface MemberMissionRepository extends JpaRepository<MemberMission, Long> {
    void deleteAllByMemberId(Long memberId);
    Page<MemberMission> findAllByMemberAndMissionStatus(Member member, MissionStatus missionStatus, PageRequest pageRequest);
    MemberMission findByMemberAndMission(Member member, Mission mission);
}
