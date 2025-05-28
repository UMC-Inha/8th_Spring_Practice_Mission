package umc.infrastructure.persistence.repository.review;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Repository;
import umc.infrastructure.persistence.entity.review.Review;
import umc.infrastructure.persistence.entity.store.Store;
import umc.infrastructure.persistence.repository.store.StoreRepository;

@Repository
@RequiredArgsConstructor
public class ReviewRepositoryImpl implements ReviewRepository{
    private final JpaReviewRepository jpaReviewRepository;

    @Override
    public Review save(Review review) {
        return jpaReviewRepository.save(review);
    }

    @Override
    public Page<Review> findAllByStore(Store store, PageRequest pageRequest) {
        return jpaReviewRepository.findAllByStore(store, pageRequest);
    }

}
