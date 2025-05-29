package umc.UMC8th.service;

import org.springframework.data.domain.Page;
import umc.UMC8th.domain.Review;

public interface MemberQueryService {
    Page<Review> getMyReviews(Long memberId, int page);
}