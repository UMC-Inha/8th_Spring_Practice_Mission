package umc.study.repository.review;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Slice;
import org.springframework.data.jpa.repository.JpaRepository;
import umc.study.domain.review.Review;
import umc.study.domain.store.Store;

import java.util.List;

public interface ReviewRepository extends JpaRepository<Review,Long> {
    List<Review> findAllByStore(Store store);
    Page<Review> findAllByStore(Store store, PageRequest pageRequest);
    Slice<Review> findByUserId(Long userId, Pageable pageRequest);
}
