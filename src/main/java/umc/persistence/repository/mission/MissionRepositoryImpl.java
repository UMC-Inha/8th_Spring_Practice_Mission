package umc.persistence.repository.mission;

import com.querydsl.core.types.Projections;
import com.querydsl.core.types.dsl.Expressions;
import com.querydsl.core.types.dsl.NumberExpression;
import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import umc.entity.category.QStoreCategory;
import umc.persistence.entity.mission.Mission;
import umc.persistence.entity.mission.MissionState;
import umc.entity.mission.QMission;
import umc.entity.mission.QUserMission;
import umc.entity.store.QStore;
import umc.presentation.dto.mission.MissionCardDto;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class MissionRepositoryImpl implements MissionRepository {
    private final JpaMissionRepository jpaMissionRepository;
    private final JPAQueryFactory jpaQueryFactory;
    private final QMission qMission = QMission.mission;
    private final QUserMission qUserMission = QUserMission.userMission;

    @Override
    public List<Mission> findMissionByUserAndState(Long userId, String missionState, Integer pagingOffset) {
        QStore qStore = QStore.store;

        return jpaQueryFactory
                .selectFrom(qMission)
                .leftJoin(qUserMission)
                .on(qUserMission.mission.eq(qMission))
                .leftJoin(qStore)
                .on(qMission.store.eq(qStore))
                .where(
                        qUserMission.user.id.eq(userId),
                        qStore.state.eq(missionState)
                )
                .orderBy(qUserMission.createdAt.desc())
                .limit(10)
                .offset((long) (pagingOffset - 1) * 10)
                .fetch();
    }

    @Override
    public Long countCompletedMissionRemainder(Long userId, String location) {
        QStore qStore = QStore.store;
        NumberExpression<Long> remainderExpr = qUserMission.id.count().mod(10L);

        return jpaQueryFactory
                .select(remainderExpr)
                .from(qUserMission)
                .join(qUserMission.mission, qMission)
                .join(qMission.store, qStore)
                .where(qUserMission.user.id.eq(userId),
                        qStore.location.eq(location),
                        qUserMission.state.eq(MissionState.COMPLETE)
                )
                .fetchOne();
    }

    @Override
    public List<MissionCardDto> findNotAcceptedMissions (Long userId, Integer pagingOffset){
        QStore qStore = QStore.store;
        QStoreCategory qStoreCategory = QStoreCategory.storeCategory;

        return jpaQueryFactory
                .select(Projections.constructor(MissionCardDto.class,
                        qStore.storeName,
                        qStoreCategory.category,
                        qMission.content,
                        qMission.point,
                        Expressions.numberTemplate(Long.class, "DATEDIFF({0}, current_timestamp)", qMission.dueDate)
                ))
                .from(qMission)
                .leftJoin(qUserMission).on(qUserMission.mission.eq(qMission).and(qUserMission.user.id.eq(userId)))
                .leftJoin(qStore).on(qMission.store.eq(qStore))
                .leftJoin(qStoreCategory).on(qStore.storeCategories.contains(qStoreCategory))
                .where(qUserMission.user.id.isNull())
                .orderBy(qMission.createdAt.desc())
                .limit(10)
                .offset((long) (pagingOffset - 1) * 10)
                .fetch();
    }

}
