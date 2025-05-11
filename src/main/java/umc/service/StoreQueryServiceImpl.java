package umc.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import umc.persistence.entity.store.Store;
import umc.persistence.repository.store.StoreRepository;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class StoreQueryServiceImpl implements StoreQueryService{
    private final StoreRepository storeRepository;
    @Override
    public Optional<Store> findStoreById(Long storeId) {
        return storeRepository.findStoreById(storeId);
    }

    @Override
    public List<Store> findStoresByNameAndScore(String name, Float score) {
        List<Store> filteredStores = storeRepository.dynamicQueryWithBooleanBuilder(name, score);

        filteredStores.forEach(store -> System.out.println("Store: " + store));

        return filteredStores;
    }
}
