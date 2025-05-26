package umc.study.repository.StoreRepository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import umc.study.domain.Mission;
import umc.study.domain.Store;

import java.util.List;

public interface StoreRepositoryCustom {
    List<Store> dynamicQueryWithBooleanBuilder(String name, Float score);

    Page<Mission> findMissionsByStore(
            Long storeId,
            String name,
            Float minScore,
            Pageable pageable
    );
}

