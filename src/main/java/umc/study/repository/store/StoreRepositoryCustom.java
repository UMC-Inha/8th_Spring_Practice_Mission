package umc.study.repository.store;

import org.springframework.data.jpa.repository.JpaRepository;
import umc.study.domain.store.Store;

import java.util.List;

public interface StoreRepositoryCustom {
    List<Store> dynamicQueryWithBooleanBuilder(String name, Float score);
}
