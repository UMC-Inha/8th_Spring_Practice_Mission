package umc.study.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import umc.study.domain.Review;
import umc.study.domain.Store;

public interface ReviewRepository extends JpaRepository<Review, Long> {
    Page<Review> findAllByStore(Store store, PageRequest pageRequest);

    @Query("SELECT r FROM Review r JOIN FETCH r.store JOIN FETCH r.member WHERE r.member.id = :userId")
    Page<Review> findAllWithStoreAndMemberByUserId(Long userId, Pageable pageable);
}
