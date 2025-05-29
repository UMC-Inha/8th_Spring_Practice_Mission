package umc.study.service.MemberService;

import org.springframework.data.domain.Page;
import umc.study.domain.Review;

public interface MemberQueryService {
    Page<Review> getMemberReviewList(Long memberId, Integer page);
}
