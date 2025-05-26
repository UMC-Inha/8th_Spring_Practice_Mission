package umc.study.repository.ReviewRepository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import umc.study.domain.Review;

public interface ReviewRepositoryCustom {
    Page<Review> findByMemberReviews(Long memberId, Pageable pageable);
}
