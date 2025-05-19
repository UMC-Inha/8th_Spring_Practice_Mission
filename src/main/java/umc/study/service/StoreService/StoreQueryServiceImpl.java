package umc.study.service.StoreService;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import umc.study.converter.StoreConverter;
import umc.study.domain.Store;
import umc.study.repository.StoreRepository.StoreRepository;
import umc.study.web.dto.Store.StoreRequestDto;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Transactional
public class StoreQueryServiceImpl implements StoreQueryService{

    private final StoreRepository storeRepository;

    @Override
    public Optional<Store> findStore(Long id) {
        return storeRepository.findById(id);
    }

    @Override
    public List<Store> findStoresByNameAndScore(String name, Float score) {
        List<Store> filteredStores = storeRepository.dynamicQueryWithBooleanBuilder(name, score);

        filteredStores.forEach(store -> System.out.println("Store: " + store));

        return filteredStores;
    }

    @Override
    public Store registerStore(StoreRequestDto.JoinDto request){

        Store store = StoreConverter.toStore(request);

        return storeRepository.save(store);
    }
}