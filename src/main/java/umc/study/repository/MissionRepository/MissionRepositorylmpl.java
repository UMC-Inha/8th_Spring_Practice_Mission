/*package umc.study.repository.MissionRepository;

import com.querydsl.jpa.JPAExpressions;
import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;

import umc.study.domain.QMission;
import umc.study.domain.QRegion;
import umc.study.domain.QStore;
import umc.study.domain.enums.MissionStatus;
import umc.study.domain.mapping.QUserMission;
import umc.study.web.dto.MissionDto;
import umc.study.web.dto.QMissionDto;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class MissionRepositoryImpl implements MissionRepositoryCustom{
    private final JPAQueryFactory queryFactory;
    private final QMission mission = QMission.mission;
    private final QStore store = QStore.store;
    private final QUserMission userMission = QUserMission.userMission;
    private final QRegion region = QRegion.region;

    // 도전 가능 미션
    @Override
    public Page<MissionDto> findAvailableMissionsByUserAndRegion(Long userId, Long regionId, java.awt.print.Pageable pageable) {
        return queryFactory
                .select(new QMissionDto( // 필요한 필드만
                        mission.id,
                        mission.missionSpec,
                        store.name,
                        mission.point,
                        mission.status
                ))
                .from(mission)
                .join(mission.store, store)
                .where(
                        store.region.id.eq(regionId),
                        mission.status.eq(MissionStatus.OPEN), // 도전 가능한 상태
                        mission.id.notIn( // 이미 도전한 미션 제외
                                JPAExpressions
                                        .select(userMission.mission.id)
                                        .from(userMission)
                                        .where(userMission.user.id.eq(userId))
                        )
                )
                .offset(pageable.getOffset())
                .limit(pageable.getPageSize())
                .fetch();
    }

    // 지역 기반 성공 미션 조회
    @Override
    public Long countCompletedMissionsByUserAndRegionId(Long userId, Long regionId) {
        return queryFactory
                .select(userMission.count()) // 성공 미션 수
                .from(userMission)
                .join(userMission.mission, mission)
                .join(mission.store, store)
                .where(userMission.user.id.eq(userId)
                        .and(userMission.status.eq(MissionStatus.COMPLETED))
                        .and(store.region.id.eq(regionId)))
                .fetchOne();
    }

}*/