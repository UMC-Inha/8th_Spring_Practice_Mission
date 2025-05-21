package umc.study.service.store;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import umc.study.domain.store.Store;
import umc.study.repository.store.StoreRepository;
import umc.study.repository.store.StoreRepositoryImpl;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true) //수정이 일어나지 않는 QueryService 경우 readOnly = true 설정하는 게 안전함
public class StoreQueryServiceImpl implements StoreQueryService{

    private final StoreRepository storeRepository;
    private final StoreRepositoryImpl storeRepositoryImpl;

    @Override
    public Optional<Store> findStore(Long id) {
        return storeRepository.findById(id);
    }

    @Override
    public List<Store> findStoresByNameAndScore(String name, BigDecimal score) {
        List<Store> filteredStores = storeRepositoryImpl.dynamicQueryWithBooleanBuilder(name, score);
        //for-each루프를 함수형 스타일로 표현한 것
        filteredStores.forEach(store -> System.out.println("Store: " + store));
        //for (Store store : filteredStores) {
        //  System.out.println("Store: " + store);
        //}
        return filteredStores;
    }
}
