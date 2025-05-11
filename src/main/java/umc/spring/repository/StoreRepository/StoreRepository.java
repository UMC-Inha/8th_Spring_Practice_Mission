package umc.spring.repository.StoreRepository;

import org.springframework.data.jpa.repository.JpaRepository;
import domain.Store;

public interface StoreRepository extends JpaRepository<Store, Long>, StoreRepositoryCustom {
}