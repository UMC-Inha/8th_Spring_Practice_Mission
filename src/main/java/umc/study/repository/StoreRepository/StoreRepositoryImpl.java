package umc.study.repository.StoreRepository;

import com.querydsl.core.BooleanBuilder;
import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;
import umc.study.domain.Mission;
import umc.study.domain.QStore;
import umc.study.domain.Store;

import java.util.List;

import static umc.study.domain.QMission.mission;

@Repository
@RequiredArgsConstructor
public class StoreRepositoryImpl implements StoreRepositoryCustom{
    private final JPAQueryFactory jpaQueryFactory;
    private final QStore store = QStore.store;

    @Override
    public List<Store> dynamicQueryWithBooleanBuilder(String name, Float score) {
        BooleanBuilder predicate = new BooleanBuilder();

        if (name != null) {
            predicate.and(store.name.eq(name));
        }

        if (score != null) {
            predicate.and(store.score.goe(4.0f));
        }

        return jpaQueryFactory
                .selectFrom(store)
                .where(predicate)
                .fetch();
    }

    @Override
    public Page<Mission> findMissionsByStore(
            Long storeId,
            Pageable pageable
    ) {
        List<Mission> content = jpaQueryFactory
                .selectFrom(mission)
                .join(mission.store, store).fetchJoin()
                .where(
                        store.id.eq(storeId)
                )
                .offset(pageable.getOffset())
                .limit(pageable.getPageSize())
                .orderBy(mission.id.asc())
                .fetch();

        Long totalCount = jpaQueryFactory
                .select(mission.count())
                .from(mission)
                .join(mission.store, store)
                .where(
                        store.id.eq(storeId)
                )
                .fetchOne();

        long total = (totalCount != null ? totalCount : 0L);

        return new PageImpl<>(content, pageable, total);
    }
}