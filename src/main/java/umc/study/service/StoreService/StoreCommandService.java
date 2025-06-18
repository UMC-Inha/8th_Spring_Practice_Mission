package umc.study.service.StoreService;

import org.springframework.data.domain.Page;
import umc.study.domain.Review;
import umc.study.domain.Store;
import umc.study.web.dto.StoreRequestDto;

public interface StoreCommandService {
    Store addStore(StoreRequestDto request);
    Page<Review> getReviewList(Long StoreId, Integer page);
}
