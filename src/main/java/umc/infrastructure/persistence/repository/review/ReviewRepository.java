package umc.infrastructure.persistence.repository.review;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import umc.infrastructure.persistence.entity.review.Review;
import umc.infrastructure.persistence.entity.store.Store;

public interface ReviewRepository {

    Page<Review> findAllByStore(Store store, PageRequest pageRequest);

    Review save(Review review);
}
