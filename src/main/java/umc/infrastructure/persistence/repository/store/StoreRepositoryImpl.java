package umc.infrastructure.persistence.repository.store;


import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import umc.infrastructure.persistence.entity.store.Store;

import java.util.Optional;

@RequiredArgsConstructor
@Repository
public class StoreRepositoryImpl implements StoreRepository {
    private final JpaStoreRepository jpaStoreRepository;

    @Override
    public Store save(Store store) {
        return jpaStoreRepository.save(store);
    }

    @Override
    public Optional<Store> findById(Long storeId) {
        return jpaStoreRepository.findById(storeId);

    }

    @Override
    public boolean existsById(Long id) {
        return jpaStoreRepository.existsById(id);
    }
}
