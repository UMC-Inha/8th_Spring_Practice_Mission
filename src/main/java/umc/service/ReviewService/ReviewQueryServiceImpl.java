package umc.service.ReviewService;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import lombok.RequiredArgsConstructor;
import umc.apiPayload.code.status.ErrorStatus;
import umc.apiPayload.exception.GeneralException;
import umc.domain.Restaurant;
import umc.domain.Review;
import umc.domain.User;
import umc.repository.RestaurantRepository.RestaurantRepository;
import umc.repository.ReviewRepository.ReviewRepository;
import umc.repository.UserRepository.UserRepository;

@Service
@RequiredArgsConstructor
public class ReviewQueryServiceImpl implements ReviewQueryService {

	private final RestaurantRepository restaurantRepository;
	private final UserRepository userRepository;
	private final ReviewRepository reviewRepository;

	@Override
	@Transactional(readOnly = true)
	public Page<Review> getMyReviewList(Long restaurantId, Long userId, Integer page) {

		Restaurant restaurant = restaurantRepository.findById(restaurantId).orElseThrow(
			() -> new GeneralException(ErrorStatus.RESTAURANT_NOT_FOUND)
		);
		User user = userRepository.findById(userId).orElseThrow(
			() -> new GeneralException(ErrorStatus.USER_NOT_FOUND)
		);

		PageRequest pageRequest = PageRequest.of(page, 10);

		return reviewRepository.findAllByRestaurantAndUser(restaurant, user, pageRequest);
	}
}
