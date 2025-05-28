package umc.infrastructure.persistence.repository.review;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import umc.infrastructure.persistence.entity.review.Review;
import umc.infrastructure.persistence.entity.store.Store;

@Repository
public interface JpaReviewRepository extends JpaRepository<Review, Long> {
    Page<Review> findAllByStore(Store store, PageRequest pageRequest);
}
