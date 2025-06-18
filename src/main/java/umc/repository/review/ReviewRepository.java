package umc.repository.review;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Slice;
import org.springframework.data.jpa.repository.JpaRepository;
import umc.domain.Restaurant;
import umc.domain.Review;
import umc.domain.User;

public interface ReviewRepository extends JpaRepository<Review, Long> {

    Page<Review> findAllByRestaurant(Restaurant restaurant, Pageable pageable);

    Page<Review> findAllByUser(User user, Pageable pageable);
    Slice<Review> findReviewsByUser(User user, Pageable pageable);
    //Page<Review> findAllByRestaurant(Restaurant restaurant, Pageable pageable);

}
