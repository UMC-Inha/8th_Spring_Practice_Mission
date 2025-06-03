package umc.UMC8th.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import umc.UMC8th.domain.Member;
import umc.UMC8th.domain.Review;
import umc.UMC8th.domain.Store;

public interface ReviewRepository extends JpaRepository<Review, Long> {
    Page<Review> findAllByStore(Store store, Pageable pageable); // 해당 Store에 대한 Review 목록을 Page로 반환
    Page<Review> findAllByMember(Member member, Pageable pageable);
}
