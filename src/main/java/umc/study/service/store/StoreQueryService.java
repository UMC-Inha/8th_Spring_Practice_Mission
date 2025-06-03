package umc.study.service.store;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Slice;
import umc.study.domain.mission.Mission;
import umc.study.domain.review.Review;
import umc.study.domain.store.Store;

import java.util.List;
import java.util.Optional;

// Query Service는 조회(읽기) 책임만 가지는 서비스
// 즉 DB로부터 조회만 하는 것. 순수 SELECT
public interface StoreQueryService {
    List<Store> findStoresByNameAndScore(String name, Float score);
    Page<Review> getReviewList(Long StoreId, Integer page);
    Slice<Mission> findMissionList(Long StoreId, Integer page, Integer size);
}
