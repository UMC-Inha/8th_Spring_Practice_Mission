package umc.study.repository.review;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import umc.study.domain.member.Member;
import umc.study.domain.review.Review;
import umc.study.domain.store.Store;

public interface ReviewRepository extends JpaRepository<Review, Long> {

    Page<Review> findAllByStore(Store store, Pageable pageable);

    Page<Review> findAllByMember(Member member, Pageable pageable);
}
