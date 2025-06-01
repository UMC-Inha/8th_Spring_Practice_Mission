package umc.service.review;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Slice;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import umc.apiPayload.code.status.ErrorStatus;
import umc.apiPayload.exception.GeneralException;
import umc.domain.Restaurant;
import umc.domain.Review;
import umc.domain.User;
import umc.repository.restaurant.RestaurantRepository;
import umc.repository.review.ReviewRepository;
import umc.repository.user.UserRepository;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class ReviewQueryServiceImpl implements ReviewQueryService {

    private final ReviewRepository reviewRepository;
    private final RestaurantRepository restaurantRepository;

    private final UserRepository userRepository;


    @Override
    public Page<Review> getReviewList(Long storeId, Integer page) {

        Restaurant restaurant = restaurantRepository.findById(storeId).orElseThrow(
                () -> new GeneralException(ErrorStatus.RESTAURANT_NOT_FOUND)
        );

        Page<Review> reviewPage = reviewRepository.findAllByRestaurant(restaurant, PageRequest.of(page, 10));
        return reviewPage;
    }

    @Override
    public Page<Review> getReviewListByUserId(Long userId, Integer page) {

        User user = userRepository.findById(userId).orElseThrow(
                () -> new GeneralException(ErrorStatus.USER_NOT_FOUND)
        );

        Page<Review> reviewPage = reviewRepository.findAllByUser(user, PageRequest.of(page, 10));
        Slice<Review> reviewSlice = reviewRepository.findReviewsByUser(user, PageRequest.of(page, 10));

        System.out.println(reviewSlice);
        System.out.println(reviewPage);

        return reviewPage;

    }

}
