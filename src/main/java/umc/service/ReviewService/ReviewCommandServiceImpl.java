package umc.service.ReviewService;

import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;
import umc.apiPayload.code.status.ErrorStatus;
import umc.apiPayload.exception.GeneralException;
import umc.converter.ReviewConverter;
import umc.domain.Restaurant;
import umc.domain.Review;
import umc.domain.User;
import umc.dto.ReviewRequestDto;
import umc.repository.RestaurantRepository.RestaurantRepository;
import umc.repository.ReviewRepository.ReviewRepository;
import umc.repository.UserRepository.UserRepository;

@Service
@RequiredArgsConstructor
public class ReviewCommandServiceImpl implements ReviewCommandService {

	private final ReviewRepository reviewRepository;
	private final RestaurantRepository restaurantRepository;
	private final UserRepository userRepository;

	@Override
	public Review joinReview(ReviewRequestDto.JoinDto request) {
		Review newReview = ReviewConverter.toReview(request);

		User user = userRepository.findByEmail(request.getUserEmail()).orElseThrow(() -> new GeneralException(
			ErrorStatus.USER_NOT_FOUND));
		Restaurant restaurant = restaurantRepository.findById(request.getRestaurantId()).orElseThrow(() -> new GeneralException(
			ErrorStatus.RESTAURANT_NOT_FOUND));

		// 연관관계 설정,,,

		return reviewRepository.save(newReview);
	}
}
