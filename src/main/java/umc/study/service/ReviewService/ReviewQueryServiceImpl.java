package umc.study.service.ReviewService;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import umc.study.domain.Review;
import umc.study.repository.ReviewRepository.ReviewRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class ReviewQueryServiceImpl implements ReviewQueryService {
    private final ReviewRepository reviewRepository;

    @Override
    public Page<Review> findReview(long id) {
        return reviewRepository.findByUserId(id, Pageable.unpaged());
    }

    @Override
    public List<Review> findReviewsByStore(long id) {
        return List.of();
    }

}
