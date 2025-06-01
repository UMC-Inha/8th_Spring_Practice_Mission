package umc.service.review;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Slice;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import umc.domain.Review;

public interface ReviewQueryService {
    Page<Review> getReviewList(Long storeId, Integer page);

    Page<Review> getReviewListByUserId(Long userId, Integer page);
}
