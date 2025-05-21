package umc.study.repository.member;

import com.querydsl.core.types.Projections;
import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import umc.study.domain.category.QCategory;
import umc.study.domain.enums.MissionStatus;
import umc.study.domain.mapping.QMemberMission;
import umc.study.domain.mapping.QPointMission;
import umc.study.domain.mapping.QStoreCategory;
import umc.study.domain.mission.QMission;
import umc.study.domain.point.QPoint;
import umc.study.domain.store.QStore;
import umc.study.repository.member.dto.MemberMissionByLocationResponseDto;
import umc.study.repository.member.dto.MemberMissionIsCompletedResponseDto;

import java.time.LocalDateTime;
import java.util.List;

@Repository
@RequiredArgsConstructor
public class MemberMissionRepositoryImpl implements MemberMissionRepositoryCustom {
    private final JPAQueryFactory jpaQueryFactory;

    @Override
    public List<MemberMissionIsCompletedResponseDto> findByMemberIdAndMissionStatus(Long memberId, MissionStatus status, int page) {

        QMemberMission memberMission = QMemberMission.memberMission;
        QMission mission = QMission.mission;
        QStore store = QStore.store;
        QPointMission pointMission = QPointMission.pointMission;
        QPoint point = QPoint.point;
        int pageSize = 7; //가져올 요소 수
        int offset = (page - 1) * pageSize; //건너뛸 페이지 수
        return jpaQueryFactory
                .select(Projections.constructor(MemberMissionIsCompletedResponseDto.class,
                        mission.missionSpec,
                        point.coin,
                        store.name,
                        memberMission.status.eq(MissionStatus.COMPLETED)))
                .from(memberMission)
                .join(memberMission.mission, mission)
                .join(mission.store, store)
                .join(pointMission.point, point)
                .where(
                        memberMission.member.id.eq(memberId),
                        memberMission.status.eq(status)
                )
                .orderBy(memberMission.updatedAt.desc())
                .limit(pageSize)
                .offset(offset)
                .fetch();
    }

    @Override
    public List<MemberMissionByLocationResponseDto> findByMemberIdAndMissionLocation(Long memberId, String location, int page) {
        QMission mission = QMission.mission;
        QStore store = QStore.store;
        QPointMission pointMission = QPointMission.pointMission;
        QPoint point = QPoint.point;
        QStoreCategory storeCategory = QStoreCategory.storeCategory;
        QCategory category = QCategory.category;
        QMemberMission memberMission = QMemberMission.memberMission;

        int pageSize = 7;
        int offset = (page - 1) * pageSize;

        return jpaQueryFactory
                .select(Projections.constructor(MemberMissionByLocationResponseDto.class,
                        mission.missionSpec,
                        point.coin,
                        store.name,
                        category.name,
                        mission.deadline))
                .from(memberMission)
                .join(memberMission.mission, mission)
                .join(mission.store, store)
                .join(pointMission.point, point)
                .leftJoin(storeCategory).on(store.id.eq(storeCategory.store.id))
                .leftJoin(category).on(storeCategory.category.id.eq(category.id))
                .where(
                        memberMission.member.id.eq(memberId),
                        memberMission.status.eq(MissionStatus.NOT_STARTED),
                        mission.local.eq(location),
                        mission.deadline.after(LocalDateTime.now())
                )
                .orderBy(mission.deadline.asc())
                .limit(pageSize)
                .offset(offset)
                .fetch();

    }

    @Override
    public Long countByMemberId(Long memberId) {
        QMemberMission memberMission = QMemberMission.memberMission;
        return jpaQueryFactory
                .select(memberMission.count())
                .from(memberMission)
                .where(
                        memberMission.member.id.eq(memberId),
                        memberMission.status.eq(MissionStatus.COMPLETED)
                )
                .fetchOne();
    }
}
