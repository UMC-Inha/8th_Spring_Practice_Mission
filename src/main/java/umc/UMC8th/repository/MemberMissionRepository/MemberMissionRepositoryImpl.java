package umc.UMC8th.repository.MemberMissionRepository;

import com.querydsl.core.types.Projections;
import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import umc.UMC8th.domain.QMission;
import umc.UMC8th.domain.mapping.QMemberMission;
import umc.UMC8th.dto.MemberMissionResponse;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class MemberMissionRepositoryImpl implements MemberMissionRepositoryCustom {

    private final JPAQueryFactory queryFactory;

    @Override
    public List<MemberMissionResponse> findMissionsByMemberId(Long memberId, int offset, int limit) {
        QMemberMission memberMission = QMemberMission.memberMission;
        QMission mission = QMission.mission;

        return queryFactory
                .select(Projections.constructor(MemberMissionResponse.class,
                        mission.id,
                        mission.title,
                        mission.status.stringValue(),
                        mission.rewardPoints,
                        memberMission.completedDate
                ))
                .from(memberMission)
                .join(memberMission.mission, mission)
                .where(memberMission.member.id.eq(memberId))
                .orderBy(
                        memberMission.completedDate.desc().nullsLast(),
                        mission.id.asc()
                )
                .offset(offset)
                .limit(limit)
                .fetch();
    }
}
