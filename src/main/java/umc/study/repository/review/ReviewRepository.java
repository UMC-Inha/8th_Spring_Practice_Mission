package umc.study.repository.review;

import org.springframework.data.jpa.repository.JpaRepository;
import umc.study.domain.review.Review;
import umc.study.domain.store.Store;

import java.util.List;

public interface ReviewRepository extends JpaRepository<Review,Long> {
    List<Review> findAllByStore(Store store);
}
