package umc.UMC8th.repository.MissionRepository;

import com.querydsl.core.types.Projections;
import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import umc.UMC8th.domain.QMember;
import umc.UMC8th.domain.QMission;
import umc.UMC8th.domain.QRegion;
import umc.UMC8th.domain.QStore;
import umc.UMC8th.domain.enums.MissionStatus;
import umc.UMC8th.dto.HomeMissionResponse;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class MissionRepositoryImpl implements MissionRepositoryCustom {

    private final JPAQueryFactory queryFactory;

    @Override
    public List<HomeMissionResponse> findHomeMissionsByRegionAndMember(String regionName, Long memberId, int offset, int limit) {
        QMission mission = QMission.mission;
        QStore store = QStore.store;
        QRegion region = QRegion.region;
        QMember member = QMember.member;

        return queryFactory
                .select(Projections.constructor(HomeMissionResponse.class, // DTO를 통해서 받을 필드 지정하기
                        mission.id,
                        mission.title,
                        mission.rewardPoints,
                        mission.deadline,
                        store.name,
                        store.address,
                        member.points,
                        region.name
                ))
                .from(mission) // 미션을 기준으로
                .join(mission.store, store) // 조인할 것들 조인
                .join(store.region, region)
                .join(member)
                .where(
                        region.name.eq(regionName),
                        mission.status.eq(MissionStatus.CHALLENGING), // 진행중인 미션만
                        member.id.eq(memberId)
                )
                .orderBy(mission.deadline.asc()) // 마감일순으로 정렬
                .offset(offset) // 페이징 처리
                .limit(limit)
                .fetch();
    }
}
