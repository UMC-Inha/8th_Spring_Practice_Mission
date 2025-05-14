package umc.study.repository.UserMissionRepository;

import com.querydsl.core.QueryFactory;
import com.querydsl.core.types.Order;
import com.querydsl.core.types.OrderSpecifier;
import com.querydsl.core.types.dsl.PathBuilder;
import com.querydsl.jpa.impl.JPAQuery;
import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;
import umc.study.domain.*;
import umc.study.domain.QMission;
import umc.study.domain.QRegion;
import umc.study.domain.QStore;
import umc.study.domain.QUser;
import umc.study.domain.enums.MissionStatus;
import umc.study.domain.mapping.QUserMission;
import umc.study.domain.mapping.UserMission;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class UserMissionRepositoryImpl implements UserMissionRepositoryCustom {
    private final JPAQueryFactory queryFactory;

    private final QUserMission userMission = QUserMission.userMission;
    private final QStore store = QStore.store;
    private final QMission mission = QMission.mission;
    private final QUser user = QUser.user;

    @Override
    public List<UserMission> findChallengingMissionByUser(Long userId, Pageable pageable) {
        // Pageable 객체에서 Sort 정보를 가져와 OrderSpecifier 배열 생성
        OrderSpecifier<?>[] orderSpecifiers = getOrderSpecifiers(pageable, UserMission.class, "userMission");

        return queryFactory
                .select(userMission)
                .join(userMission.mission, mission).fetchJoin()
                .join(mission.store, store).fetchJoin()
                .where(userMission.user.id.eq(userId)
                        .and(userMission.status.eq(MissionStatus.CHALLENGING)))
                .orderBy(orderSpecifiers)
                .offset(pageable.getOffset())
                .limit(pageable.getPageSize())
                .fetch();
    }

    private OrderSpecifier<?>[] getOrderSpecifiers(Pageable pageable, Class<UserMission> userMissionClass, String userMission) {
        return pageable.getSort().stream()
                .map(order -> {
                    Order direction = order.isAscending() ? Order.ASC : Order.DESC;
                    PathBuilder<?> entityPath = new PathBuilder<>(entityClass, entityPathName);

                    if (order.getProperty().startsWith("mission.")) {
                        PathBuilder<Mission> missionPath = new PathBuilder<>(Mission.class, "mission");

                        String missionField = order.getProperty().substring("mission.".length());
                        return new OrderSpecifier(direction, missionPath.get(missionField, Comparable.class));
                    }
                    return new OrderSpecifier(direction, entityPath.get(order.getProperty(), Comparable.class));
                })
                .toArray(OrderSpecifier[]::new);
    }

    @Override
    public List<UserMission> findCompletedMissionByUser(Long userId, Pageable pageable) {
        return queryFactory
                .selectFrom(userMission)
                .join(userMission.mission, mission).fetchJoin()
                .join(mission.store, store).fetchJoin()
                .where(userMission.user.id.eq(userId)
                        .and(userMission.status.eq(MissionStatus.COMPLETED)))
                .orderBy(orderSpecifiers)
                .offset(pageable.getOffset())
                .limit(pageable.getPageSize())
                .fetch();
    }

    @Override
    public Long countCompletedMissionByUser(Long userId, String regionName) {
        return queryFactory
                .select(userMission.count())
                .from(userMission)
                .join(userMission.mission, mission)
                .join(mission.store, store)
                .where(userMission.user.id.eq(userId)
                        .and(userMission.status.eq(MissionStatus.COMPLETED))
                        .and(store.region.name.eq(regionName)))
                .fetchOne();
    }
}
