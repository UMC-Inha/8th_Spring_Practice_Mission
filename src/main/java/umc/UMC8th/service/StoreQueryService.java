package umc.UMC8th.service;

import org.springframework.data.domain.Page;
import umc.UMC8th.domain.Mission;
import umc.UMC8th.domain.Review;
import umc.UMC8th.domain.Store;

import java.util.List;
import java.util.Optional;

public interface StoreQueryService {

    Optional<Store> findStore(Long id);
    List<Store> findStoresByNameAndScore(String name, Float score);
    Page<Review> getReviewList(Long storeId, int page);
    Page<Mission> getMissionList(Long storeId, int page);
}
