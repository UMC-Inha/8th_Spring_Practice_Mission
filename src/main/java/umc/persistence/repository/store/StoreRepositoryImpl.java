package umc.persistence.repository.store;

import com.querydsl.core.BooleanBuilder;
import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import umc.entity.store.QStore;
import umc.persistence.entity.store.Store;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Repository
public class StoreRepositoryImpl implements StoreRepository {
    private final JpaStoreRepository jpaStoreRepository;
    private final JPAQueryFactory jpaQueryFactory;
    private final QStore store = QStore.store;

    @Override
    public List<Store> dynamicQueryWithBooleanBuilder(String name, Float score) {
        BooleanBuilder predicate = new BooleanBuilder();

        if (name != null) {
            predicate.and(store.storeName.eq(name));
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
    public Optional<Store> findStoreById(Long storeId) {
        return jpaStoreRepository.findById(storeId);
    }

}
